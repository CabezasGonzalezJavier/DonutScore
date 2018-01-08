package com.thedeveloperworldisyours.donutscore.utils

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 * Created by javiergonzalezcabezas on 8/1/18.
 */
class CustomTextView(context: Context?, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    init {
        val typeface = Typeface.createFromAsset(getContext().assets, "font/roboto.ttf")
        setTypeface(typeface)
    }
}