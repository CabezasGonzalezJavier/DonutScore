package com.thedeveloperworldisyours.donutscore

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import com.thedeveloperworldisyours.donutscore.data.CreditReportInfo
import com.thedeveloperworldisyours.donutscore.data.Example
import com.thedeveloperworldisyours.donutscore.data.ExampleAPI
import com.thedeveloperworldisyours.donutscore.score.ScoreManager
import com.thedeveloperworldisyours.donutscore.util.MockedCall
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith


/**
 * Created by javiergonzalezcabezas on 7/1/18.
 */
class ScoreManagerTest {

    var apiMock = mock<ExampleAPI>()

    @Before
    fun setup() {
        apiMock = mock<ExampleAPI>()
    }

    @Test
    fun success_check_response_is_not_null() = testBlocking {
        // given
        Example(null, CreditReportInfo(543, null, null, null, null,null, null, null, null), null, null, null, null).mockApiCall()

        // when
        val scoreManager = ScoreManager(apiMock)
        val example = scoreManager.getExample()

        // then
        assertNotNull(example)
    }

    @Test
    fun error_Exception_received_from_service_call() {
        // given
        val callMock = MockedCall<Example>(exception = Throwable())
        whenever(apiMock.getExample()).thenReturn(callMock)

        // when
        val newsManager = ScoreManager(apiMock)

        // then
        assertFailsWith<Throwable> {
            runBlocking {
                newsManager.getExample()
            }
        }
    }

    private fun testBlocking(block: suspend CoroutineScope.() -> Unit) {
        runBlocking(Unconfined, block)
    }

    private fun Example.mockApiCall() {
        val callMock = MockedCall<Example>(this)
        whenever(apiMock.getExample()).thenReturn(callMock)
    }
}