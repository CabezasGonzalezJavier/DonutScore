package com.thedeveloperworldisyours.donutscore.score

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thedeveloperworldisyours.donutscore.R
import com.thedeveloperworldisyours.donutscore.ScoreApp
import com.thedeveloperworldisyours.donutscore.utils.BaseFragment
import com.thedeveloperworldisyours.donutscore.utils.inflate
import kotlinx.android.synthetic.main.score_fragment.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
class ScoreFragment : BaseFragment() {

    @Inject lateinit var scoreManager: ScoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScoreApp.scoreComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        requestScore()
        return container?.inflate(R.layout.score_fragment)
    }

    private fun requestScore() {

        job = launch(UI) {
            try {
                val retrievedScore = scoreManager.getExample()
                score_textView.setText(retrievedScore.creditReportInfo?.score.toString())
            } catch (e: Throwable) {
                if (isVisible) {
                    Snackbar.make(score_textView, e.message.orEmpty(), Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY") { requestScore() }
                            .show()
                }
            }
        }
    }
}