package com.example.test


import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class EnigmaTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    var ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.EnigmaTextView)
    private lateinit var te: TextView


    override fun onFinishInflate() {
        super.onFinishInflate()
        inflate(context, R.layout.enigma_text_view, this)
        te = findViewById(R.id.txt)
        ta.getString(R.styleable.EnigmaTextView_enigmaText)?.let { setText(it) }
        ta.getColor(R.styleable.EnigmaTextView_enigmaColor,Color.BLUE)?.let{ setColor(it) }
        ta.recycle()
    }

    private fun setText(text: String) {
        te.text = text
    }
    private fun setColor(color:Int)
    {
        te.setTextColor(color)
    }


}