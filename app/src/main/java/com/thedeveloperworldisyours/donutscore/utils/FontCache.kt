package com.thedeveloperworldisyours.donutscore.utils

import android.content.Context
import android.graphics.Typeface
import java.util.*


/**
 * Created by javiergonzalezcabezas on 8/1/18.
 */
class FontCache {

    private val fontCache = Hashtable<String, Typeface>()

    fun getTypeface(name: String, context: Context): Typeface? {
        var tf = fontCache.get(name)
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name)
            } catch (e: Exception) {
                return null
            }

            fontCache.put(name, tf)
        }
        return tf
    }
}