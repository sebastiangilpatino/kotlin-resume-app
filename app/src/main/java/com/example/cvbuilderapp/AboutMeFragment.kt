package com.example.cvbuilderapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutMeFragment : Fragment(R.layout.fragment_about_me) {

    private var titleList: ArrayList<String> = DataHolder.instance!!.aboutMeTitle;
    private var descList: ArrayList<String> = DataHolder.instance!!.aboutMeDesc;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_about_me, container, false)
        val rv: RecyclerView = rootView.findViewById(R.id.rvAboutMe)
        val linearLayoutManager = LinearLayoutManager(activity)
        rv.layoutManager = linearLayoutManager

        val intent = requireActivity().intent
        val title: String? = intent.getStringExtra("titleAboutMe")
        val description: String? = intent.getStringExtra("descriptionAboutMe")
        if (title != null && description != null) {
            titleList.add(title)
            descList.add(description)
            intent.removeExtra("titleAboutMe")
            intent.removeExtra("descriptionAboutMe")
        }
        var tab = "about-me"
        val adapter = MyAdapter(this.requireContext(), titleList, descList,tab)
        // Set adapter to your RecyclerView
        rv.adapter = adapter

        //FAB
        val fab: View = rootView.findViewById(R.id.fabAboutMe)
        fab.setOnClickListener {
            val intent = Intent(this.requireContext(), AddCard::class.java)
            intent.putExtra("tab", "about-me")
            startActivity(intent)
        }

        return rootView
    }
}