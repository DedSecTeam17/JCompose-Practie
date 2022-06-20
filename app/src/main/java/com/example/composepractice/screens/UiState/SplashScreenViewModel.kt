package com.example.composepractice.screens.UiState

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import java.util.*

class SplashScreenViewModel() : ViewModel() {



    private fun startTimerFor(seconds: Int,timerAction: TimerAction) {
        val timer = object : CountDownTimer(20000, (seconds * 1000).toLong()) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                timerAction.onFinish()
            }
        }
        timer.start()
    }
}

interface TimerAction {
     fun onFinish()
}