package com.example.occasion.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.occasion.R

import com.example.occasion.databinding.FragmentAddBinding
import com.example.occasion.model.Occasion
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AddFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val TAG = "AddFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        database = Firebase.database.reference
        initClick()
        return binding.root
    }

    private fun initClick() {
        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCreate.setOnClickListener {
            findNavController().navigate(R.id.action_menu_add_to_createCommunityFragment)
        }


        binding.btnPost.setOnClickListener {
            val postText = binding.inputLayout.editText?.text.toString()
            if (postText.isNotEmpty()) {
                postTextToFirebase(postText)
            } else {
                Toast.makeText(context, "Digite algo antes de postar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun postTextToFirebase(postText: String) {
        binding.progressBar.visibility = View.VISIBLE

        val postId = database.child("posts").push().key
        val post = Occasion(id = postId, description = postText)

        if (postId != null) {
            database.child("posts").child(postId).setValue(post).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Post successful")
                    Toast.makeText(context, "Postado com sucesso", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                } else {
                    Log.e(TAG, "Post failed", task.exception)
                    Toast.makeText(context, "Falha ao postar", Toast.LENGTH_SHORT).show()
                }
                binding.progressBar.visibility = View.INVISIBLE
            }
        } else {
            Log.e(TAG, "Erro ao gerar ID do post")
            Toast.makeText(context, "Erro ao gerar ID do post", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
