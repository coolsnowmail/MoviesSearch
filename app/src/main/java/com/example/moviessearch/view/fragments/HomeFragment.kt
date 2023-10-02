package com.example.moviessearch.view.fragments

import com.example.moviessearch.domain.Film
import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviessearch.view.rv_adapters.FilmListRecyclerAdapter
import com.example.moviessearch.view.rv_adapters.TopSpacingItemDecoration
import com.example.moviessearch.utils.AnimationHelper
import com.example.moviessearch.view.MainActivity
import com.example.moviessearch.viewmodel.HomeFragmentViewModel
import com.megamovies.moviessearch.R
import com.megamovies.moviessearch.databinding.FragmentHomeBinding
import com.megamovies.moviessearch.databinding.MergeHomeScreenContentBinding




class HomeFragment : Fragment() {
//    init {
//        exitTransition = Slide(Gravity.START).apply { duration = 500;mode = Slide.MODE_OUT }
//        reenterTransition = Slide(Gravity.START).apply { duration = 500; }
//    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mergebinding: MergeHomeScreenContentBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)
    }

    private var filmsDataBase = listOf<Film>()

        set(value) {
            if (field == value) return
            field = value
            filmsAdapter.addItems(field)
        }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(
            binding.homeFragmentRoot,
            requireActivity(),
            1
        )
        viewModel.filmListLiveData.observe(viewLifecycleOwner,
        Observer<List<Film>> {
            filmsDataBase = it
        })
        val scene = Scene.getSceneForLayout(
            binding.homeFragmentRoot,
            R.layout.merge_home_screen_content,
            requireContext()
        )
        val searchSlide = Slide(Gravity.TOP).addTarget(R.id.search_view)
        val recyclerSlide = Slide(Gravity.BOTTOM).addTarget(R.id.main_recycler)
        val customTransition = TransitionSet().apply {
            duration = 1000
            addTransition(recyclerSlide)
            addTransition(searchSlide)
        }
        TransitionManager.go(scene, customTransition)
        mergebinding = MergeHomeScreenContentBinding.bind(binding.root)
        mergebinding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(filmsDataBase)
        mergebinding.searchView.setOnClickListener {
            mergebinding.searchView.isIconified = false
        }
        mergebinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText != null) {
                    if (newText.isEmpty()) {
                        filmsAdapter.addItems(filmsDataBase)
                        return true
                    }
                    val result = filmsDataBase.filter {
                        it.title?.contains(newText, ignoreCase = true) ?: false
                    }
                    filmsAdapter.addItems(result)
                }
                return true
            }
        })
    }
}


