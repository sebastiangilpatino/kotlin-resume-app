package com.example.cvbuilderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AddCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        val btn: View = findViewById(R.id.addButtonToHome)
        btn.setOnClickListener {
            val title = findViewById<EditText>(R.id.editTitleAddToHome).text.toString()
            val description = findViewById<EditText>(R.id.editDescriptionAddToHome).text.toString()
            if (title == "" || description == "") {
                Toast.makeText(this, "Cannot be empty", Toast.LENGTH_LONG).show()
            } else {
                val intent = intent
                when (intent.getStringExtra("tab")) {
                    "about-me" -> {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("titleAboutMe", title)
                        intent.putExtra("descriptionAboutMe", description)
                        startActivity(intent)
                    }
                    "home" -> {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("titleHome", title)
                        intent.putExtra("descriptionHome", description)
                        startActivity(intent)
                    }
                    "work" -> {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("titleWork", title)
                        intent.putExtra("descriptionWork", description)
                        startActivity(intent)
                    }
                    "contact" -> {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("titleContact", title)
                        intent.putExtra("descriptionContact", description)
                        startActivity(intent)
                    }
                }
            }

        }
    }
}
