package com.example.cvbuilderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private var homeTitle: ArrayList<String> = DataHolder.instance!!.homeTitle;
    private var homeDesc: ArrayList<String> = DataHolder.instance!!.homeDesc;
    private val aboutMeTitle: ArrayList<String> = DataHolder.instance!!.aboutMeTitle;
    private val aboutMeDesc: ArrayList<String> = DataHolder.instance!!.aboutMeDesc;
    private val workTitle: ArrayList<String> = DataHolder.instance!!.workTitle;
    private val workDesc: ArrayList<String> = DataHolder.instance!!.workDesc;
    private val contactTitle: ArrayList<String> = DataHolder.instance!!.contactTitle;
    private val contactDesc: ArrayList<String> = DataHolder.instance!!.contactDesc;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent
        var title: String? = intent.getStringExtra("name")
        var desc: String? = intent.getStringExtra("description")
        var tab: String? = intent.getStringExtra("tab")
        findViewById<TextView>(R.id.name).text = title
        findViewById<TextView>(R.id.desc).text = desc
        val btn = findViewById<Button>(R.id.delete)
        btn.setOnClickListener {
            if (tab == "home") {
                homeTitle.remove(title)
                homeDesc.remove(desc)
            } else if (tab == "about-me") {
                aboutMeTitle.remove(title)
                aboutMeDesc.remove(desc)
            } else if (tab == "work") {
                workTitle.remove(title)
                workDesc.remove(desc)
            } else if (tab == "contact") {
                contactTitle.remove(title)
                contactDesc.remove(desc)
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}