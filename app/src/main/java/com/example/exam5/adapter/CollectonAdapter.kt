package com.example.exam5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.R
import com.example.exam5.model.Collection

class CollectonAdapter(var context: Context, var items: ArrayList<Collection>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_collection, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item  = items[position]

        if(holder is ItemViewHolder){
            holder.apply {
                photo.setImageResource(item.photoC)
                name.text = item.collection
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var photo = view.findViewById<ImageView>(R.id.iv_photo_cal)
        var name = view.findViewById<TextView>(R.id.tv_collection)
    }
}