package com.thedeveloperworldisyours.donutscore.data

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
interface EndpointAPI {

    @GET("/values")
    fun getValues(): Call<Example>
}