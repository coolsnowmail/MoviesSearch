package com.example.moviessearch

import android.content.Context
import android.graphics.*
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

    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = strokeWidthAttr
        flags = Paint.ANTI_ALIAS_FLAG
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        paint.shader =
            LinearGradient(0f, 0f, 0f, w.toFloat(), Color.BLUE, Color.YELLOW, Shader.TileMode.MIRROR)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(width / 2F, height / 2F, 400F, paint)
    }

//    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawPoints(floatArrayOf(0F,0F,0F,300F,300F,0F),paint)
//    }

}