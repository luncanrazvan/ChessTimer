package com.mindorks.framework.chess_timer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.mindorks.framework.chess_timer.R
import com.mindorks.framework.chess_timer.ui.fragments.SetTimerDialogFragment
import com.mindorks.framework.chess_timer.uitls.PlayerCountDownTimer
import com.mindorks.framework.chess_timer.uitls.SetTimerDialogFragmentListener
import kotlinx.android.synthetic.main.activity_timer.*
import kotlinx.android.synthetic.main.set_timer_layout.*

class TimerActivity : AppCompatActivity(), SetTimerDialogFragmentListener {

    private lateinit var countDownTimerPlayerOne: PlayerCountDownTimer
    private lateinit var countDownTimerPlayerTwo: PlayerCountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        showSetTimerDialog()

        player_one.setOnClickListener {
            changePlayerOneDoneVisibility()
        }

        player_two.setOnClickListener {
            changePlayerTwoDoneVisibility()
        }

        resume.setOnClickListener {
            resumeGame()
        }

        pause.setOnClickListener {
            pauseGame()
        }
    }

    private fun changePlayerOneDoneVisibility(){
        Log.i("Player 1:", "Player one is done.")
        player_one.isEnabled  = false
        player_one.isVisible = false
        player_two.isEnabled = true
        player_two.isVisible = true
        timerPlayer1.isVisible = false
        timerPlayer2.isVisible = true
        countDownTimerPlayerOne.timerPause()
        countDownTimerPlayerTwo.timerResume()
    }

    private fun changePlayerTwoDoneVisibility(){
        Log.i("Player 2:", "Player two is done.")
        player_one.isEnabled  = true
        player_one.isVisible = true
        player_two.isEnabled = false
        player_two.isVisible = false
        timerPlayer1.isVisible = true
        timerPlayer2.isVisible = false
        countDownTimerPlayerTwo.timerPause()
        countDownTimerPlayerOne.timerResume()
    }

    private fun initializeTimers(timerValue: Long){
        Log.i("Timers", "Initializing timers.")
        countDownTimerPlayerOne = PlayerCountDownTimer(timerValue, timerPlayer1, this)
        countDownTimerPlayerTwo = PlayerCountDownTimer(timerValue, timerPlayer2, this)
    }

    private fun pauseGame(){
        if(countDownTimerPlayerOne.isRunning){
            Log.i("Player 1", "Paused")
            countDownTimerPlayerOne.timerPause()
            player_one.isEnabled  = false
            pausedPlayer1.isVisible = true
        }else{
            Log.i("Player 2", "Paused")
            countDownTimerPlayerTwo.timerPause()
            player_two.isEnabled = false
            pausedPlayer2.isVisible = true
        }
    }

    private fun resumeGame(){
        if(player_one.isVisible && !countDownTimerPlayerOne.isRunning){
            Log.i("Player 1", "Resumed")
            countDownTimerPlayerOne.timerResume()
            player_one.isEnabled  = true
            pausedPlayer1.isVisible = false
        }else if(player_two.isVisible && !countDownTimerPlayerTwo.isRunning){
            Log.i("Player 2", "Resumed")
            countDownTimerPlayerTwo.timerResume()
            player_two.isEnabled  = true
            pausedPlayer2.isVisible = false
        }
    }

    private fun showSetTimerDialog(){
        val setTimerFragment = SetTimerDialogFragment()
        setTimerFragment.show(supportFragmentManager, "Set Timer Value dialog is up")
    }

    override fun onReturnValue(timerValue: Long) {
        
        Log.i("Return Value", "On Returned Value $timerValue")
        initializeTimers(timerValue)
        countDownTimerPlayerTwo.startTime()
    }
}