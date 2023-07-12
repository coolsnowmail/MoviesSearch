package com.example.moviessearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.megamovies.moviessearch.MainActivity
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {
    private lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.f1next.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.blankFragment2)
        }

        binding.f1pref.setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment1()

    }
}
