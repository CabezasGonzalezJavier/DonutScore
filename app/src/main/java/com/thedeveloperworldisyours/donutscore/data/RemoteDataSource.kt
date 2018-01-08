package com.thedeveloperworldisyours.donutscore.data

import retrofit2.Call
import javax.inject.Inject

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
class RemoteDataSource @Inject constructor(private val service: Service) : ExampleAPI {

    //we provide a function to consume the API and request the Example
    override fun getExample(): Call<Example> {
        return service.getValues()
    }
}