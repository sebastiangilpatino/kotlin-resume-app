package com.example.cvbuilderapp

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var s1 = resources.getStringArray(R.array.fruits);
        var s2 = resources.getStringArray(R.array.desc);
        var s3 = resources.getStringArray(R.array.detail);
        rv.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this, s1, s2, imageges, s3)
        // Set adapter to your RecyclerView
        rv.adapter = adapter
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