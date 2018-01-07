package com.thedeveloperworldisyours.donutscore.di.score

import com.thedeveloperworldisyours.donutscore.di.AppModule
import com.thedeveloperworldisyours.donutscore.di.NetworkModule
import com.thedeveloperworldisyours.donutscore.score.ScoreFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ScoreModule::class,
        NetworkModule::class)
)
interface ScoreComponent {

    fun inject(scoreFragment: ScoreFragment)

}