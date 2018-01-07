package com.thedeveloperworldisyours.donutscore.di

import com.thedeveloperworldisyours.donutscore.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.URL_BASE)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}