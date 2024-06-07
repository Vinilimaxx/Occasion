package com.example.occasion.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.occasion.R
import com.example.occasion.databinding.FragmentLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        initClicks()
    }

    private fun initClicks() {

        binding.btnLogin.setOnClickListener{validateData()}

        binding.btnRegister.setOnClickListener(){
            findNavController().navigate(R.id.registerFragment)
        }

        binding.btnRecover.setOnClickListener(){
            findNavController().navigate(R.id.recoverFragment)
        }
    }

    private fun validateData(){
        val email = binding.edtEmail.text.toString()
//        val password = binding.edtPasswordText.text.toString().trim()
        val password = binding.edtPassword.text.toString()

        if (email.isNotEmpty()){
            if (password.isNotEmpty()){

                binding.progressBar.isVisible = true
                loginUser(email, password)

            }else{
                Toast.makeText(requireContext(), "Informe sua Senha!!", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "Informe seu Email!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.menu_home)
                } else {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), "Email ou senha incorreta", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}