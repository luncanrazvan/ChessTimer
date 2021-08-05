package com.mindorks.framework.chess_timer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mindorks.framework.chess_timer.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button.setOnClickListener {
            goToTimer()
        }

        settings_button.setOnClickListener{
            gotToSetting()
        }
    }

    private fun goToTimer(){
        val intent = Intent(this, TimerActivity::class.java)
        startActivity(intent);
        finish()
    }

    private fun gotToSetting(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        finish()
    }
}