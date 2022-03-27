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

    var titleList: ArrayList<String> = DataHolder.instance!!.title;
    var descList: ArrayList<String> = DataHolder.instance!!.desc;
//    var detail = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val title: String? = intent.getStringExtra("title")
        val description: String? = intent.getStringExtra("description")
        if(title != null && description != null) {
            titleList.add(title)
            descList.add(description)
        }
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(this, titleList, descList, imageges)
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
}