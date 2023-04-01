package com.example.moviessearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.megamovies.moviessearch.databinding.FragmentBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentBinding? = null
    private val binding : FragmentBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textInFragment.text = "helllo programmatic"
//        binding.textInFragment.textSize = 35.0F
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}