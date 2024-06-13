package com.example.occasion.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.occasion.databinding.FragmentMessageBinding
import com.example.occasion.model.Community
import com.example.occasion.ui.adapter.ClickCommunityAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MessageFragment : Fragment() {
    private val TAG = "MessageFragment"
    private lateinit var database: DatabaseReference
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val adapter = ClickCommunityAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        database = Firebase.database.reference
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        getAllCommunities()

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getAllCommunities() {
        binding.progressBar.visibility = View.VISIBLE

        database.child("communities").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val communitiesList = mutableListOf<Community>()
                for (communitySnapshot in dataSnapshot.children) {
                    val community = communitySnapshot.getValue(Community::class.java)
                    if (community != null) {
                        communitiesList.add(community)
                    }
                }

                adapter.setCommunityData(communitiesList)
                binding.progressBar.visibility = View.INVISIBLE
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "Database error: $error")
                binding.progressBar.visibility = View.INVISIBLE
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
