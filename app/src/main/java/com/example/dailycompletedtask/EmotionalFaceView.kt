package com.example.dailycompletedtask

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class EmotionalFaceView : View{

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    // Some colors for the face background, eyes and mouth.
    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK
    // Face border width in pixels
    private var borderWidth = 4.0f
    // View size in pixels
    private var size = 320


    constructor(context: Context) : super(context) {

    }
    constructor(context: Context, attrs: AttributeSet): super(context){

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)    }

    private fun drawMouth(canvas: Canvas?) {


    }

    private fun drawEyes(canvas: Canvas?) {

    }

    private fun drawFaceBackground(canvas: Canvas?) {

        // 1
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        // 2
        val radius = size / 2f

        // 3
        canvas?.drawCircle(size / 2f, size / 2f, radius, paint)

        // 4
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        // 5
        canvas?.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)



    }

}