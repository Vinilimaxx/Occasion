package com.example.occasion.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.occasion.databinding.TextAdapterBinding
import com.example.occasion.model.Occasion

class TextAdapter(
    private val occasionList: List<Occasion>
) : RecyclerView.Adapter<TextAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TextAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val occasion = occasionList[position]
        holder.binding.textDescription.text = occasion.description
    }

    override fun getItemCount() = occasionList.size

    inner class MyViewHolder(val binding: TextAdapterBinding) : RecyclerView.ViewHolder(binding.root)
}
