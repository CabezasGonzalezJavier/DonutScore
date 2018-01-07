package com.thedeveloperworldisyours.donutscore.score

import com.thedeveloperworldisyours.donutscore.data.Example
import com.thedeveloperworldisyours.donutscore.data.ExampleAPI
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResult
import javax.inject.Inject

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
class ScoreManager @Inject constructor(private val api: ExampleAPI) {

    suspend fun getExample(): Example {
        val result = api.getExample().awaitResult()
        return when (result) {
            is Result.Ok -> result.value
            is Result.Error -> throw Throwable("HTTP error: ${result.response.message()}")
            is Result.Exception -> throw result.exception
            else -> {
                throw Throwable("Something went wrong, please try again later.")
            }
        }
    }
}