package com.jacee.preferenceview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jacee.widget.PreferenceView

class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)

        findViewById<View>(R.id.one).setOnClickListener {
            Toast.makeText(this, "one", Toast.LENGTH_SHORT).show()
        }

        findViewById<PreferenceView>(R.id.four).setOnPreferenceListener(object : PreferenceView.OnPreferenceListener {
            override fun onSwitchChanged(checked: Boolean) {
                Toast.makeText(this@ExampleActivity, if (checked) "打开" else "关闭", Toast.LENGTH_SHORT).show()
            }

        })


    }
}