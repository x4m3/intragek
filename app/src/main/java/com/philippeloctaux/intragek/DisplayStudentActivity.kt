package com.philippeloctaux.intragek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_student)

        /* Get the intent that started this activity and extract its string */
        val student = intent.getStringExtra(STUDENT)

        /* Capture the layout's TextView and set the string as its text */
        val textView = findViewById<TextView>(R.id.studentText).apply {
            text = student
        }
    }
}
