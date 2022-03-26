package com.example.cvbuilderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class AddCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
    }

    fun addItemToHome(view: View) {
        val title = findViewById<EditText>(R.id.editTitleAddToHome).text.toString()
        val description = findViewById<EditText>(R.id.editDescriptionAddToHome).text.toString()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("description", description)
        startActivity(intent)
    }
}
