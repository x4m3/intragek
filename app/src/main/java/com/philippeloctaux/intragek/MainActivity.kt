package com.philippeloctaux.intragek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

const val STUDENT = "com.philippeloctaux.intragek.STUDENT"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clearText(view: View) {
        /* hide keyboard */
        hideKeyboard(this@MainActivity, view)

        /* clear text */
        findViewById<EditText>(R.id.autologinText).text.clear()
        findViewById<EditText>(R.id.studentText).text.clear()
    }

    fun sendStudent(view: View) {
        /* hide keyboard */
        hideKeyboard(this@MainActivity, view)

        /* get student login or email address from activity */
        val input = findViewById<EditText>(R.id.studentText).text.toString()

        /* make sure it passes through regex */
        val student = Regex(pattern = "^([a-z]+-?)+([1-9]?)\\.{1}([a-z]+-?)+(@epitech.eu)?")
            .find(input = input)?.value

        if (student.isNullOrBlank()) {
            /* display toast with error message if it doesn't pass regex*/
            Toast.makeText(applicationContext, R.string.error_empty_login, Toast.LENGTH_LONG).show()
        } else {
            /* pass student to intent and start new activity */
            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(STUDENT, student)
            }
            startActivity(intent)
        }
    }
}
