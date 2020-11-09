package com.flutterwave.raveembed.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flutterwave.raveembed.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, PayFragment())
            .commit()

    }

}