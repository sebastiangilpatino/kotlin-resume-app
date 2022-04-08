package com.example.cvbuilderapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class WorkFragment : Fragment(R.layout.fragment_work) {

    private var titleList: ArrayList<String> = DataHolder.instance!!.workTitle;
    private var descList: ArrayList<String> = DataHolder.instance!!.workDesc;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_work, container, false)
        val rv: RecyclerView = rootView.findViewById(R.id.rvWork)
        val linearLayoutManager = LinearLayoutManager(activity)
        rv.layoutManager = linearLayoutManager

        val intent = requireActivity().intent
        val title: String? = intent.getStringExtra("titleWork")
        val description: String? = intent.getStringExtra("descriptionWork")
        if (title != null && description != null) {
            titleList.add(title)
            descList.add(description)
            intent.removeExtra("titleWork")
            intent.removeExtra("descriptionWork")
        }

        var tab = "work"
        val adapter = MyAdapter(this.requireContext(), titleList, descList, tab)
        // Set adapter to your RecyclerView
        rv.adapter = adapter

        //FAB
        val fab: View = rootView.findViewById(R.id.fabWork)
        fab.setOnClickListener {
            val intent = Intent(this.requireContext(), AddCard::class.java)
            intent.putExtra("tab", "work")
            startActivity(intent)
        }

        return rootView
    }


}