package com.philippeloctaux.intragek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

const val STUDENT = "com.philippeloctaux.intragek.STUDENT"
const val AUTOLOGIN = "com.philippeloctaux.intragek.AUTOLOGIN"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /* clear text */
    fun clearText(view: View) {
        findViewById<EditText>(R.id.autologinText).text.clear()
        findViewById<EditText>(R.id.studentText).text.clear()
    }

    fun sendStudentAutologin(view: View) {
        /* hide keyboard */
        hideKeyboard(this@MainActivity, view)

        /* get input */
        val student_input = findViewById<EditText>(R.id.studentText).text.toString()
        val autologin_input = findViewById<EditText>(R.id.autologinText).text.toString()

        /* make sure it passes through regex */
        val student = Regex(pattern = "^([a-z]+-?)+([1-9]?)\\.{1}([a-z]+-?)+$")
            .matchEntire(input = student_input)?.value
        val autologin = Regex(pattern = "^(https:\\/\\/intra.epitech.eu\\/auth-)([a-z0-9]{40})\$")
            .matchEntire(input = autologin_input)?.value

        /* if autologin doesn't pass regex */
        if (autologin.isNullOrBlank()) {
            /* display toast */
            Toast.makeText(applicationContext, R.string.error_invalid_autologin, Toast.LENGTH_LONG).show()
            return
        }

        /* if student doesn't pass regex */
        if (student.isNullOrBlank()) {
            /* display toast */
            Toast.makeText(applicationContext, R.string.error_invalid_student, Toast.LENGTH_LONG).show()
            return
        }

        /* pass student to intent and start new activity */
        val intent = Intent(this, DisplayStudentActivity::class.java).apply {
            putExtra(STUDENT, student)
            putExtra(AUTOLOGIN, autologin)
        }
        startActivity(intent)
    }
}
