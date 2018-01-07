package com.thedeveloperworldisyours.donutscore.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}


fun <T> androidLazy(initializer: () -> T) : Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)