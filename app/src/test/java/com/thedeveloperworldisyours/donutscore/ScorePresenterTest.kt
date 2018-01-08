package com.thedeveloperworldisyours.donutscore

import com.nhaarman.mockito_kotlin.whenever
import com.thedeveloperworldisyours.donutscore.data.CreditReportInfo
import com.thedeveloperworldisyours.donutscore.data.Example
import com.thedeveloperworldisyours.donutscore.data.ExampleAPI
import com.thedeveloperworldisyours.donutscore.score.ScorePresenter
import com.thedeveloperworldisyours.donutscore.util.MockedCall
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test


/**
 * Created by javiergonzalezcabezas on 7/1/18.
 */
class ScorePresenterTest {

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
        val scorePresenter = ScorePresenter(apiMock)
        val example = scorePresenter.getExample()

        // then
        assertNotNull(example)
    }

    @Test
    fun success_check_response_in_score() = testBlocking {

        // given
        Example(null, CreditReportInfo(543, null, null, null, 700,null, null, null, null), null, null, null, null).mockApiCall()
        var example = Example(null, CreditReportInfo(543, null, null, null, 700,null, null, null, null), null, null, null, null)

        // when
        val scorePresenter = ScorePresenter(apiMock)
        val response = scorePresenter.getExample()

        // then
        assertNotNull(response)
        assert(response!!.creditReportInfo?.score == example!!.creditReportInfo?.score)
        assert(response!!.creditReportInfo?.maxScoreValue == example!!.creditReportInfo?.maxScoreValue)
    }

    private fun testBlocking(block: suspend CoroutineScope.() -> Unit) {
        runBlocking(Unconfined, block)
    }

    private fun Example.mockApiCall() {
        val callMock = MockedCall<Example>(this)
        whenever(apiMock.getExample()).thenReturn(callMock)
    }
}