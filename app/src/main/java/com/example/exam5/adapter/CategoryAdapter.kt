package com.example.exam5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.R
import com.example.exam5.model.Category

class CategoryAdapter(var context : Context, var items : ArrayList<Category>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_category, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item  = items[position]

        if(holder is CategoryViewHolder){
            holder.apply {
                photo.setImageResource(item.photo)
                category.text = item.category
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class CategoryViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var photo = view.findViewById<ImageView>(R.id.iv_photo)
        var category = view.findViewById<TextView>(R.id.tv_category)
    }
}