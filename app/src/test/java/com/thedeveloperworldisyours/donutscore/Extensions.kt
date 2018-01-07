package com.thedeveloperworldisyours.donutscore

import org.mockito.Mockito

/**
 * Created by javiergonzalezcabezas on 7/1/18.
 */

inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)