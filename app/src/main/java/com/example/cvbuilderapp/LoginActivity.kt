package com.example.cvbuilderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    var userList = ArrayList<User>(
        arrayListOf(
            User("Jorge", "Gil", "gsebasp@gmail.com", "12345"),
            User("Maria", "Estrada", "mestrada@gmail.com", "12345"),
            User("Pedro", "Salazar", "psantiago@gmail.com", "12345"),
            User("Milton", "Gonzalez", "miltonfree@gmail.com", "12345"),
            User("Anderson", "Arbelaez", "aarbelaez@gmail.com", "12345")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent = intent
        val firstName: String? = intent.getStringExtra("firstName")
        val lastName: String? = intent.getStringExtra("lastName")
        val email: String? = intent.getStringExtra("email")
        val password: String? = intent.getStringExtra("password")
        userList.add(
            User(firstName.toString(), lastName.toString(), email.toString(), password.toString())
        )
        val btn = findViewById<TextView>(R.id.textView2)
        btn.setOnClickListener { forgetPassword() }
    }

    private fun forgetPassword() {
        val mail = findViewById<EditText>(R.id.username).text.toString()
        if (mail != "") {
            val password: String? = userList
                .filter { it.username == mail }
                .map { it.password }
                .firstOrNull()
            if (password != null) {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "[Password]: $password")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Not in memory", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Email required", Toast.LENGTH_LONG).show()
        }
    }

    fun validateLogin(view: View) {
        val username = findViewById<EditText>(R.id.username).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        val user: User? =
            userList.firstOrNull { it.username == username && it.password == password }

        if (user != null) {
            //open new activity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        } else {
            Toast.makeText(this, "login failed", Toast.LENGTH_LONG).show()
        }
    }

    fun createAccountMain(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}