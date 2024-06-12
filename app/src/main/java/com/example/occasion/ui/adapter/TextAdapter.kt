package com.example.occasion.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.occasion.databinding.TextAdapterBinding
import com.example.occasion.model.Occasion

class TextAdapter(
    private var occasionList: MutableList<Occasion>
) : RecyclerView.Adapter<TextAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = TextAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val occasion = occasionList[position]
        holder.bind(occasion)
    }

    override fun getItemCount() = occasionList.size

    inner class MyViewHolder(private val binding: TextAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(occasion: Occasion) {
            binding.textDescription.text = occasion.description
        }
    }
}
