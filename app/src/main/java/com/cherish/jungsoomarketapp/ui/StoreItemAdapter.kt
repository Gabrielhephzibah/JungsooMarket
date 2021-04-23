package com.cherish.jungsoomarketapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cherish.jungsoomarketapp.R
import com.cherish.jungsoomarketapp.model.ShoppingData
import kotlinx.android.synthetic.main.item_list_layout.view.*

class StoreItemAdapter(val callback: (Int) -> Unit) : ListAdapter<ShoppingData,StoreItemAdapter.StoreViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_layout, parent, false)
        return StoreViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val item = getItem(position)
        holder.name.text = item.name
        holder.price.text = "$${item.price}"
    }

    class StoreViewHolder(itemView :View, callback: (Int) -> Unit ) : RecyclerView.ViewHolder(itemView){
    val name = itemView.name
    val price = itemView.price
    var cancel:ImageView = itemView.cancel


    init {
        cancel.setOnClickListener{
            callback(adapterPosition)
        }
    }

}

    fun getData(int: Int): ShoppingData {
        return getItem(int)
    }


    class DiffCallback : DiffUtil.ItemCallback<ShoppingData>() {
        override fun areItemsTheSame(oldItem: ShoppingData, newItem: ShoppingData): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: ShoppingData,
            newItem: ShoppingData
        ): Boolean {
            return oldItem == newItem
        }
    }
}