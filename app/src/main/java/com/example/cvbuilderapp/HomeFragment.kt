package com.example.cvbuilderapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var titleList: ArrayList<String> = DataHolder.instance!!.title;
    private var descList: ArrayList<String> = DataHolder.instance!!.desc;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val rv: RecyclerView = rootView.findViewById(R.id.rv)
        val linearLayoutManager = LinearLayoutManager(activity)
        rv.layoutManager = linearLayoutManager

        val intent = requireActivity().intent
        val title: String? = intent.getStringExtra("title")
        val description: String? = intent.getStringExtra("description")
        if (title != null && description != null) {
            titleList.add(title)
            descList.add(description)
        }

        val adapter = MyAdapter(this.requireContext(), titleList, descList)
        // Set adapter to your RecyclerView
        rv.adapter = adapter

                //FAB
        val fab: View = rootView.findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this.requireContext(), AddCard::class.java)
            startActivity(intent)
        }

        return rootView
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
}