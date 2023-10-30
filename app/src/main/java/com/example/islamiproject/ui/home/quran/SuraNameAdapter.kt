package com.example.islamiproject.ui.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamiproject.databinding.ItemSuraNameBinding

class SuraNameAdapter(private var items: List<String>) : Adapter<SuraNameAdapter.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemSuraNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.itemSuraNameTitle.text = items[position]
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(items[position], position)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: String, position: Int)
    }

    class ViewHolder(val viewBinding: ItemSuraNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root)


}