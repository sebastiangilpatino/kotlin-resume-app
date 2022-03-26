package com.example.cvbuilderapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun createAccountRegistry(view: View) {
        val firstName = findViewById<EditText>(R.id.firstNameRegister).text.toString()
        val lastName = findViewById<EditText>(R.id.lastNameRegister).text.toString()
        val email = findViewById<EditText>(R.id.emailRegister).text.toString()
        val password = findViewById<EditText>(R.id.passwordRegister).text.toString()
        if (firstName == "" || lastName == "" || email == "" || password == "") {
            Toast.makeText(this, "Required fields", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
        }
    }
}