package com.thedeveloperworldisyours.donutscore

import android.app.Application
import com.thedeveloperworldisyours.donutscore.di.AppModule
import com.thedeveloperworldisyours.donutscore.di.score.DaggerScoreComponent
import com.thedeveloperworldisyours.donutscore.di.score.ScoreComponent

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
class ScoreApp : Application() {
    companion object {
        lateinit var scoreComponent: ScoreComponent
    }

    override fun onCreate() {
        super.onCreate()
        scoreComponent = DaggerScoreComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}