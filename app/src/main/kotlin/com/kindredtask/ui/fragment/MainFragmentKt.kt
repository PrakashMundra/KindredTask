package com.kindredtask.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kindredtask.R
import com.kindredtask.data.model.GameKt
import com.kindredtask.databinding.FragmentMainKtBinding
import com.kindredtask.ui.adapter.ListAdapterKt
import com.kindredtask.viewmodel.ListViewModelKt

class MainFragmentKt : Fragment() {
    companion object {
        val TAG = MainFragmentKt::class.simpleName
    }

    private lateinit var mBinding: FragmentMainKtBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_kt, container, false)
        setUpRecyclerView()
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            val viewModel = ViewModelProviders.of(this).get(ListViewModelKt::class.java)
            mBinding.viewModel = viewModel
            subscribeModel(viewModel)
        }
    }

    private fun setUpRecyclerView() {
        context?.let {
            val manager = LinearLayoutManager(context)
            mBinding.recyclerView.layoutManager = manager
            val divider = DividerItemDecoration(context, manager.orientation)
            val drawable = ContextCompat.getDrawable(it, R.drawable.divier)
            if (drawable != null)
                divider.setDrawable(drawable)
            mBinding.recyclerView.addItemDecoration(divider)
        }
    }

    private fun subscribeModel(viewModel: ListViewModelKt) {
        viewModel.getGamesList().observe(this, Observer { games ->
            if (games != null && !games.isEmpty()) {
                setAdapter(games)
                viewModel.isEmpty.set(false)
            } else
                viewModel.isEmpty.set(true)
            viewModel.loading.set(false)
        })
    }

    private fun setAdapter(games: List<GameKt>) {
        val adapter = ListAdapterKt(games)
        mBinding.recyclerView.adapter = adapter
    }
}