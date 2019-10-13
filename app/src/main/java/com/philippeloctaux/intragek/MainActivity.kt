package com.philippeloctaux.intragek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.philippeloctaux.intragek.LOGIN"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when user taps on Send button */
    fun sendMessage(view: View) {
        val login = findViewById<EditText>(R.id.editText).text.toString()
        if (login.isBlank()) {
            // display toast with error message
            Toast.makeText(applicationContext, R.string.error_empty_login, Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, login)
            }
            startActivity(intent)
        }
    }
}
