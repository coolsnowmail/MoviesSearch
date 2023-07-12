package com.example.moviessearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.megamovies.moviessearch.MainActivity
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.FragmentBlankBinding

class BlankFragmen : Fragment() {
    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.f0next.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.blankFragment1)
        }

        binding.f0pref.setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = BlankFragmen()

    }
}