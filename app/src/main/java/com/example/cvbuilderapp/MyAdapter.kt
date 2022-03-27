package com.example.cvbuilderapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*

class MyAdapter(
    var context: Context, var text1: ArrayList<String>, var text2: ArrayList<String>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v);
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.playout.apply {
            tv1.text = text1[position]
            tv2.text = text2[position]
        }
        holder.itemView.playout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            var res = text1!![position]
            Toast.makeText(context, " $res clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("name", text1[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return text1!!.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}