package com.example.cvbuilderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var imageges = intArrayOf(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.cherries,
        R.drawable.dates,
        R.drawable.grapes,
        R.drawable.mango
    )

    var titleHome = ArrayList<String>()
    var descriptionHome = ArrayList<String>()
    var detail = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val newTitle: String? = intent.getStringExtra("title")
        val newDescription: String? = intent.getStringExtra("description")

        if (newTitle != null && newDescription != null) {
            //added here
            titleHome.add(newTitle)
            descriptionHome.add(newDescription)
        }

        rv.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this, titleHome, descriptionHome, imageges, detail)
        // Set adapter to your RecyclerView
        rv.adapter = adapter
        //FAB
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, AddCard::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(applicationContext, item.title.toString(), Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

    fun addElement(arr: Array<String>, element: String): Array<String> {
        val mutableArray = arr.toMutableList()
        mutableArray.add(element)
        return mutableArray.toTypedArray()
    }

}