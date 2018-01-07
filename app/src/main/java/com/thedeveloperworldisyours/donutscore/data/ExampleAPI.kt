package com.thedeveloperworldisyours.donutscore.data

import retrofit2.Call

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
interface ExampleAPI {
    fun getExample(): Call<Example>
}