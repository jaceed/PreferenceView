package com.jacee.preferenceview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)

        findViewById<View>(R.id.one).setOnClickListener {

        }

    }
}