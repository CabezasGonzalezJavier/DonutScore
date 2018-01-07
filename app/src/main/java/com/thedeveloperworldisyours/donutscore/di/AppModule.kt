package com.thedeveloperworldisyours.donutscore.di

import android.app.Application
import android.content.Context
import com.thedeveloperworldisyours.donutscore.ScoreApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
@Module
class AppModule (val app: ScoreApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication() : Application = app

}