package com.example.moviessearch

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.megamovies.moviessearch.R

class CustomView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) :
    View(context, attributeSet) {

    private var strokeWidthAttr = 0f

    init {
        val attributes =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.CustomView, 0, 0)

        try {
            strokeWidthAttr = attributes.getFloat(R.styleable.CustomView_stroke_width, 0F)
        } finally {
            attributes.recycle()
        }
    }


    override fun onDraw(canvas: Canvas?) {
        val paint = Paint().apply {
            color = Color.GREEN
            style = Paint.Style.STROKE
            strokeWidth = strokeWidthAttr
        }
        canvas?.drawLine(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}