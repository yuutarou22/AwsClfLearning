package com.example.awsclflearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)

        MobileAds.initialize(this){}
        val adRequest = AdRequest.Builder().build()
        ad_area.loadAd(adRequest)

        aws_practice_button.setOnClickListener {
            var intent = Intent(this, PracticeActivity::class.java)
            startActivity(intent)
        }

        aws_learning_button.setOnClickListener {
            var intent = Intent(this, LearningActivity::class.java)
            startActivity(intent)
        }

        settings_button.setOnClickListener {
            var intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}