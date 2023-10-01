package com.example.moviessearch

import android.content.Context
import android.graphics.*

import android.util.AttributeSet
import android.view.View

class ClockView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) :
    View(context, attributeSet) {
    private val rect: Rect()
    private val numerals = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    private lateinit var paintClockCircle: Paint
    private lateinit var dashPaintThin: Paint
    private lateinit var clockPaint: Paint

    private lateinit var staticCanvas: Canvas
    private var radius: Float = 0f
    private var centerX: Float = 0f
    private var centerY: Float = 0f
    private var scaleSize: Float = 60f

    private var isStaticPictureDraw: Boolean = false
    private lateinit var bitmap: Bitmap

    private var dashColor = Color.WHITE
    private var digitColor = Color.WHITE
    private var arrowColor = Color.RED

    init {
        initDrawingTools()
    }
    override fun onDraw(canvas: Canvas?) {

        if (!isStaticPictureDraw) {
            drawStaticPicture()
        }
        canvas?.drawBitmap(bitmap, centerX - radius, centerY - radius, null)

    }

    private fun drawStaticPicture() {
        bitmap = Bitmap.createBitmap(
            (centerX * 2).toInt(),
            (centerY * 2).toInt(),
            Bitmap.Config.ARGB_8888
        )

        staticCanvas = Canvas(bitmap)
        drawClock(staticCanvas)

        isStaticPictureDraw = true
    }

    private fun initDrawingTools() {
        dashPaintThin = Paint().apply {
            color = dashColor
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 0.01F
            isAntiAlias = true
        }
        clockPaint = Paint(dashPaintThin).apply {
            color = digitColor
            textSize = scaleSize * 1.5F
            strokeWidth = 2F
            isAntiAlias = true
        }
        paintClockCircle = Paint().apply {
            color = Color.BLACK
            style = Paint.Style.FILL
            strokeWidth = 10F
            isAntiAlias = true
        }
    }

    private fun drawClock(canvas: Canvas) {
        canvas.translate(centerX, centerY)
        canvas.drawCircle(0f, 0f, radius, paintClockCircle)

        for (number in numerals) {
            val text = number.toString()
            val digitOffset = 0.9F
            clockPaint.getTextBounds(text, 0, text.length, rect)

            val angle = Math.PI / 6 * (number - 3)

            val x = (Math.cos(angle) * radius * digitOffset - rect.width() / 2).toFloat()
            val y = (Math.sin(angle) * radius * digitOffset + rect.height() / 2).toFloat()

            canvas.drawText(text, x, y, clockPaint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val choseWidth = chosenDimension(widthMode, widthSize)
        val choseHeight = chosenDimension(heightMode, heightSize)

        val minSide = Math.min(choseWidth, choseHeight)
        centerX = minSide.div(2F)
        centerY = minSide.div(2F)

        setMeasuredDimension(minSide, minSide)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = if (width > height) {
            height.div(2F)
        } else {
            width.div(2F)
        }
    }

    private fun chosenDimension(mode: Int, size: Int) =
        when (mode) {
            MeasureSpec.AT_MOST, MeasureSpec.EXACTLY -> size
            else -> 300
        }
}