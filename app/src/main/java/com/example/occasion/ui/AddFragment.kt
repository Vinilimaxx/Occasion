package com.example.occasion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.occasion.R
import com.example.occasion.databinding.FragmentAddBinding
import com.example.occasion.databinding.FragmentHomeBinding
import com.google.firebase.database.DatabaseReference


class AddFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container,false)
        return  binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}