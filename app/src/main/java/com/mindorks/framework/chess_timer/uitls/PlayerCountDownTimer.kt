package com.mindorks.framework.chess_timer.uitls

import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import com.mindorks.framework.chess_timer.R
import kotlin.properties.Delegates

class PlayerCountDownTimer(timePlayerCountDown: Long, private val textView: TextView, private val context: Context) {

    var isRunning: Boolean = false
    private var millisLeft: Long = timePlayerCountDown
    private var countDownInterval : Long = 1

    private  var countDownTimer : CountDownTimer = object : CountDownTimer(millisLeft, countDownInterval) {
        override fun onTick(milliseconds: Long) {
            Log.i("Timer:", "One second passed on timer.")
            millisLeft = milliseconds
            countDownInterval = 1000
            textView.text = (context.getString(R.string.time, ((milliseconds / 1000) / 60).toInt(), ((milliseconds / 1000) % 60).toInt()))
        }

        override fun onFinish() {
            Log.i("Timer:", "Timer finished.")
            isRunning = false
            textView.setText(R.string.time_has_ended)
        }
    }

    fun startTime() {
        Log.i("Timer:", "Timer has started.")
        isRunning = true
        countDownTimer.start()
    }

    fun timerPause() {
        Log.i("Timer:", "Timer paused.")
        isRunning = false
        countDownTimer.cancel()
        countDownInterval = 1
    }

    fun timerResume() {
        Log.i("Timer:", "Timer resumed.")
        isRunning = true
        countDownTimer = object : CountDownTimer(millisLeft, countDownInterval) {
            override fun onTick(milliseconds: Long) {
                Log.i("Timer:", "One second passed on timer.")
                millisLeft = milliseconds
                countDownInterval = 1000
                textView.text = (context.getString(R.string.time, ((milliseconds / 1000) / 60).toInt(), ((milliseconds / 1000) % 60).toInt()))
            }

            override fun onFinish() {
                Log.i("Timer:", "Timer finished.")
                isRunning = false
                textView.setText(R.string.time_has_ended)
            }
        }.start()
    }
}
