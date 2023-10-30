package com.example.islamiproject.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamiproject.databinding.ItemHadethNumberBinding
import com.example.islamiproject.ui.model.Hadeth

class HadethNumberAdapter(var items: List<Hadeth>?) :
    Adapter<HadethNumberAdapter.ViewHolder>() {

    var onItemClick: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemHadethNumberBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.itemHadethNumber.text = items!![position].title
        holder.itemView.setOnClickListener {
            onItemClick?.onItemClick(items!![position], position)
        }
    }
    fun bindItems(newList:List<Hadeth>){
        items = newList
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(item: Hadeth, position: Int)
    }

    class ViewHolder(val viewBinding: ItemHadethNumberBinding) : RecyclerView.ViewHolder(viewBinding.root)


}