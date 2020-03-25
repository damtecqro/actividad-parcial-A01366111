package com.test.pokedex.ui.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.test.pokedex.R

class ActivitySplashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val SPLASHSCREEN_DURATION:Long = 3000

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splaschscreen)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        supportActionBar?.hide()

        val handler: Handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(this@ActivitySplashscreen, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP
            intent.putExtra("USERNAME","pokedex")
            intent.putExtra("PASSWORD","pokedex")
            startActivity(intent)
            finish()
        },SPLASHSCREEN_DURATION)
    }
}






