package com.example.ocassion.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ocassion.R
import com.example.ocassion.databinding.FragmentLoginBinding
import com.example.ocassion.databinding.FragmentSplashBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initClicks() {
        binding.btnRegister.setOnClickListener(){
            findNavController().navigate(R.id.registerFragment)
        }
        binding.btnRecover.setOnClickListener(){
            findNavController().navigate(R.id.recoverFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}