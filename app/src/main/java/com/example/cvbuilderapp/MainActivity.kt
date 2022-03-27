package com.example.cvbuilderapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tab adapter
        val tabAdapter = TabAdapter(supportFragmentManager, lifecycle)
        viewpager.adapter = tabAdapter
        TabLayoutMediator(tlayaout, viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.home)
                }
                1 -> {
                    tab.text = "About Me"
                    tab.setIcon(R.drawable.about_me)
                }
                2 -> {
                    tab.text = "Work"
                    tab.setIcon(R.drawable.work)
                }
                3 -> {
                    tab.text = "Contact"
                    tab.setIcon(R.drawable.contacts)
                }
            }
        }.attach()

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