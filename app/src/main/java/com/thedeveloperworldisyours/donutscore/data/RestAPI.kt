package com.thedeveloperworldisyours.donutscore.data

import com.thedeveloperworldisyours.donutscore.utils.Constants.URL_BASE
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
class RestAPI {

    private val endpointAPI: EndpointAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        endpointAPI = retrofit.create(EndpointAPI::class.java)
    }

    //we provide a function to consume the API and request the Example
    fun getExample(after: String, limit: String): Call<Example> {
        return endpointAPI.getValues()
    }
}