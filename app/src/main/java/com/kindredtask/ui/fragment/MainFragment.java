package com.kindredtask.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kindredtask.R;
import com.kindredtask.data.model.Game;
import com.kindredtask.databinding.FragmentMainBinding;
import com.kindredtask.ui.adapter.ListAdapter;
import com.kindredtask.viewmodel.ListViewModel;

import java.util.List;

public class MainFragment extends Fragment {
    public static final String TAG = MainFragmentKt.class.getSimpleName();
    private FragmentMainBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        setUpRecyclerView();
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ListViewModel viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
            mBinding.setViewModel(viewModel);
            subscribeModel(viewModel);
        }
    }

    private void setUpRecyclerView() {
        if (getContext() != null) {
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            mBinding.recyclerView.setLayoutManager(manager);
            DividerItemDecoration divider = new DividerItemDecoration(getContext(), manager.getOrientation());
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.divier);
            if (drawable != null)
                divider.setDrawable(drawable);
            mBinding.recyclerView.addItemDecoration(divider);
        }
    }

    private void subscribeModel(ListViewModel viewModel) {
        viewModel.getGamesList().observe(this, games -> {
                    if (games != null && games.size() > 0) {
                        setAdapter(games);
                        viewModel.isEmpty.set(false);
                    } else
                        viewModel.isEmpty.set(true);
                    viewModel.loading.set(false);
                }
        );
    }

    private void setAdapter(List<Game> games) {
        ListAdapter adapter = new ListAdapter(games);
        mBinding.recyclerView.setAdapter(adapter);
    }
}
