package com.example.moviessearch

import android.content.Context
import android.util.AttributeSet
import android.view.View

class ClockView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) :
    View(context, attributeSet) {
    private var radius: Float = 0f
    private var centerX: Float = 0f
    private var centerY: Float = 0f
    private var scaleSize: Float = 60f

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val choseWidth = chosenDimention(widthMode, widthSize)
        val choseHeight = chosenDimention(heightMode, heightSize)

        val minSide = Math.min(choseWidth, choseHeight)
        centerX  = minSide.div(2F)
        centerY  = minSide.div(2F)



    }
}