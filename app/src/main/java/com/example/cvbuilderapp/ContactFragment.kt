package com.example.cvbuilderapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ContactFragment : Fragment(R.layout.fragment_contact) {

    private var titleList: ArrayList<String> = DataHolder.instance!!.contactTitle;
    private var descList: ArrayList<String> = DataHolder.instance!!.contactDesc;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_contact, container, false)
        val rv: RecyclerView = rootView.findViewById(R.id.rvContact)
        val linearLayoutManager = LinearLayoutManager(activity)
        rv.layoutManager = linearLayoutManager

        val intent = requireActivity().intent
        val title: String? = intent.getStringExtra("titleContact")
        val description: String? = intent.getStringExtra("descriptionContact")
        if (title != null && description != null) {
            titleList.add(title)
            descList.add(description)
            intent.removeExtra("titleContact")
            intent.removeExtra("descriptionContact")
        }

        val adapter = MyAdapter(this.requireContext(), titleList, descList)
        // Set adapter to your RecyclerView
        rv.adapter = adapter

        //FAB
        val fab: View = rootView.findViewById(R.id.fabContact)
        fab.setOnClickListener {
            val intent = Intent(this.requireContext(), AddCard::class.java)
            intent.putExtra("tab", "contact")
            startActivity(intent)
        }

        return rootView
    }

}