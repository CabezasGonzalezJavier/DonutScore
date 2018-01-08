package com.thedeveloperworldisyours.donutscore.di.score

import com.thedeveloperworldisyours.donutscore.data.ExampleAPI
import com.thedeveloperworldisyours.donutscore.data.RemoteDataSource
import com.thedeveloperworldisyours.donutscore.data.Service
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
@Module
class ScoreModule {

    @Provides
    @Singleton
    fun provideExampleAPI(service: Service): ExampleAPI = RemoteDataSource(service)

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): Service = retrofit.create(Service::class.java)

    /**
     * NewsManager is automatically provided by Dagger as we set the @Inject annotation in the
     * constructor, so we can avoid adding a 'provider method' here.
     */
}