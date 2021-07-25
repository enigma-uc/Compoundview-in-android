package com.example.test

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class EnigmaAddBtn @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val non_zero_add_btn by lazy { findViewById<TextView>(R.id.add_icon) }
    private val non_zero_add_text by lazy { findViewById<TextView>(R.id.non_zero_add_text)}
    private val zero_count_btn by lazy { findViewById<CardView>(R.id.zero_count_btn) }
    private val non_zero_count_btn by lazy { findViewById<CardView>(R.id.non_zero_count_btn) }
    private val non_zero_add_icon by lazy { findViewById<TextView>(R.id.non_zero_add_icon) }
    private val non_zero_sub_icon by lazy { findViewById<TextView>(R.id.non_zero_sub_icon) }

    private var quantity: Int = 0

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.add_button, this, false)
        addView(view)
        quantity.let {
            if(quantity>0) setNonZeroBtn() else setZeroBtn()
        }
         non_zero_add_btn.setOnClickListener {
             if(quantity == 0)
             {
                 quantity += 1
               setBtn()
             }
        }
        non_zero_add_icon.setOnClickListener {
            if(quantity > 0)
            {
                quantity += 1
                setBtn()
            }
        }
        non_zero_sub_icon.setOnClickListener {
            if(quantity > 1)
            {
                quantity -= 1
                setBtn()
            }
            else if(quantity == 1)
            {
                quantity -= 1
                setZeroBtn()
            }
        }
    }
    private fun setBtn()
    {
        non_zero_add_text.text = quantity.toString()
        zero_count_btn.visibility = View.GONE
        non_zero_count_btn.visibility = View.VISIBLE
        non_zero_sub_icon.setBackgroundDrawable(ContextCompat.getDrawable(context,R.drawable.sub_background))
        non_zero_add_icon.setBackgroundDrawable(ContextCompat.getDrawable(context,R.drawable.add_background))
    }

    private fun setZeroBtn()
    {
        zero_count_btn.visibility = View.VISIBLE
        non_zero_count_btn.visibility = View.GONE
    }

    private fun setNonZeroBtn()
    {
        non_zero_count_btn.visibility = View.VISIBLE
        zero_count_btn.visibility = View.GONE
    }

}