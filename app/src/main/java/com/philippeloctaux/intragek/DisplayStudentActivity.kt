package com.philippeloctaux.intragek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import coil.api.load
import kotlinx.android.synthetic.main.activity_display_student.*

class DisplayStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_student)

        val student = intent.getStringExtra(STUDENT)
        val autologin = intent.getStringExtra(AUTOLOGIN)

        /* get string from intent and set it to the TextView */
        val textView = findViewById<TextView>(R.id.studentText).apply {
            text = student
        }

        imageView.load("$autologin/file/userprofil/profilview/$student.jpg")
    }
}

