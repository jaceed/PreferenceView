package com.jacee.preferenceview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jacee.preferenceview.R.*

class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_example)

        findViewById<View>(R.id.one).setOnClickListener {

        }

    }
}