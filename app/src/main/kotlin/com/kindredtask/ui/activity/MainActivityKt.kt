package com.kindredtask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kindredtask.R
import com.kindredtask.ui.fragment.MainFragmentKt

class MainActivityKt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, MainFragmentKt(), MainFragmentKt.TAG).commit()
    }
}