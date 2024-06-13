package com.example.occasion.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.occasion.databinding.FragmentCreateCommunityBinding
import com.example.occasion.model.Community
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CreateCommunityFragment : Fragment() {
    private lateinit var database: DatabaseReference
    private var _binding: FragmentCreateCommunityBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateCommunityBinding.inflate(inflater, container, false)
        database = Firebase.database.reference
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btncomunty.setOnClickListener {
            val name = binding.communityName.text.toString()
            val description = binding.communityDescription.text.toString()
            postCommunityToFirebase(name, description)
        }
    }

    private fun postCommunityToFirebase(communityName: String, communityDescription: String) {
//        binding.progressBar.visibility = View.VISIBLE

        val communityId = database.child("communities").push().key
        Toast.makeText(context, "$communityId", Toast.LENGTH_SHORT).show()
        val communities = Community(id = communityId, description = communityDescription, name = communityName)

        if (communityId != null) {
            database.child("communities").child(communityId).setValue(communities).addOnCompleteListener { task ->
                if (task.isSuccessful) {
//                    Log.d(AddFragment.TAG, "Post successful")
                    Toast.makeText(context, "Postado com sucesso", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                } else {
//                    Log.e(AddFragment.TAG, "Post failed", task.exception)
                    Toast.makeText(context, "Falha ao postar", Toast.LENGTH_SHORT).show()
                }
                binding.progressBar.visibility = View.INVISIBLE
            }
        } else {
//            Log.e(AddFragment.TAG, "Erro ao gerar ID do post")
            Toast.makeText(context, "Erro ao gerar ID do post", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}