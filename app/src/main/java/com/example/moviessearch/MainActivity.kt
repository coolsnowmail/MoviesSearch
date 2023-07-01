package com.megamovies.moviessearch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.megamovies.moviessearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val snackbar = Snackbar.make(binding.mainLayout, "SnackBar", Snackbar.LENGTH_INDEFINITE)
        binding.fab.setOnClickListener {
            snackbar.show()
        }


        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset == 0) {
                binding.toolbarLayout.setExpandedTitleColor(
                    ContextCompat.getColor(
                        this,
                        R.color.black
                    )
                )
            }
            if (verticalOffset == appBarLayout.scrollBarSize) {
                binding.toolbarLayout.setExpandedTitleColor(
                    ContextCompat.getColor(
                        this,
                        androidx.appcompat.R.color.abc_secondary_text_material_dark
                    )
                )

            }
            binding.toolbarLayout.title = verticalOffset.toString()
        })


        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_dail -> Toast.makeText(this, "Dial", Toast.LENGTH_SHORT).show()
                R.id.action_mail -> Toast.makeText(this, "Mail", Toast.LENGTH_SHORT).show()
                R.id.action_map -> Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()
            }
            false
        }

        val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.bottomSheety)
        binding.fab.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                binding.fab.scaleX = 1 - slideOffset
                binding.fab.scaleY = 1 - slideOffset

                binding.backgroundTint.alpha = slideOffset/1.5f
            }
        })

    }

}