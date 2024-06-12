package com.example.occasion.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.occasion.databinding.FragmentHomeBinding
import com.example.occasion.model.Occasion
import com.example.occasion.ui.adapter.TextAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference
    private lateinit var textAdapter: TextAdapter
    private val occasionList = mutableListOf<Occasion>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        database = FirebaseDatabase.getInstance().reference.child("posts")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        loadDataFromFirebase()
    }

    private fun setupRecyclerView() {
        textAdapter = TextAdapter(occasionList)
        binding.recyclerViewPosts.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = textAdapter
        }
    }

    private fun loadDataFromFirebase() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                occasionList.clear()
                for (postSnapshot in snapshot.children) {
                    val post = postSnapshot.getValue(Occasion::class.java)
                    post?.let { occasionList.add(it) }
                }
                textAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
