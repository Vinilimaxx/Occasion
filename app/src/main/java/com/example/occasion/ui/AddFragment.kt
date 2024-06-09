package com.example.occasion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.occasion.R
import com.example.occasion.databinding.FragmentAddBinding
import com.example.occasion.databinding.FragmentHomeBinding
import com.example.occasion.helper.FirebaseHelper
import com.example.occasion.model.Occasion
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference


class AddFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var occasion: Occasion
    private var newOccasion: Boolean = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container,false)
        return  binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        initListeners()
    }

    private fun initListeners(){
//        binding.btnCancel.setOnClickListener(){
//            findNavController().navigate(R.id.menu_home)
//        }


        binding.btnPost.setOnClickListener{ validateData() }
    }

    private fun validateData(){
        val description = binding.textDescription.text.toString().trim()

        if(description.isNotEmpty()){

            binding.progressBar.isVisible = true


            if (newOccasion) occasion = Occasion()
            occasion.description = description

            saveOccasion()
        }else{
            Toast.makeText(
                requireContext(),"Inicie sua Occasion",Toast.LENGTH_SHORT

            ).show()
        }
    }

    private fun saveOccasion(){

        FirebaseHelper
            .getDatabse()
            .child("posts")
            .child(FirebaseHelper.getIdUser() ?: "")
            .child(occasion.id)
            .setValue(occasion)
            .addOnCompleteListener{ occasion ->
                if (occasion.isSuccessful){
                    if (newOccasion){
                        findNavController().popBackStack()
                        Toast.makeText(requireContext(), "Occasion iniciada", Toast.LENGTH_SHORT).show()
                    }
                }

            }.addOnFailureListener{
                Toast.makeText(requireContext(), "Falhou Occasion iniciada", Toast.LENGTH_SHORT).show()
            }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}