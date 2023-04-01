package com.example.moviessearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.NextFragmentBinding

class NextFgmt : Fragment(R.layout.next_fragment) {
    private var _bindind: NextFragmentBinding? = null
    private val binding: NextFragmentBinding get() = _bindind!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindind = NextFragmentBinding.bind(view)
        binding.textInNextFragment.text = "ssdgsdgfdsgfdgdfgdfgfdgfd"
    }

    override fun onDestroyView() {
        _bindind = null
        super.onDestroyView()
    }
}