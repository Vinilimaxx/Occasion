package com.example.occasion.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.occasion.databinding.ClickCommunityBinding
import com.example.occasion.model.Community

class ClickCommunityAdapter () : RecyclerView.Adapter<CommunitiesViewHolder>() {
    private var communities = mutableListOf<Community>()

    fun setCommunityData(communities: List<Community>) {
        this.communities = communities.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunitiesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ClickCommunityBinding.inflate(inflater, parent, false)
        return CommunitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunitiesViewHolder, position: Int) {
        val community = communities[position]
        holder.bind(community)
    }

    override fun getItemCount(): Int {
        return communities.size
    }
}

class CommunitiesViewHolder(val binding: ClickCommunityBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(community: Community) {
       binding.txtfbt.text = community.name
        binding.txtfb.text = community.description
    }
}