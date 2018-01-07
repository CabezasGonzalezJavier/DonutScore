package com.thedeveloperworldisyours.donutscore.utils

import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job
/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
open class BaseFragment : Fragment() {

    protected var job: Job? = null

    override fun onResume() {
        super.onResume()
        job = null
    }

    override fun onPause() {
        super.onPause()
        job?.cancel()
        job = null
    }
}