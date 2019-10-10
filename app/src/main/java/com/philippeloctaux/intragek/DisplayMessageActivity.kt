package com.philippeloctaux.intragek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        /* Get the intent that started this activity and extract its string */
        val login = intent.getStringExtra(EXTRA_MESSAGE)

        /* Capture the layout's TextView and set the string as its text */
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = login
        }
    }
}
