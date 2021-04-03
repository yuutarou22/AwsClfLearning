package com.example.awsclflearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.awsclflearning.Fragment.TopFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // AdMobの初期化とロード
        MobileAds.initialize(this){}
        val adRequest = AdRequest.Builder().build()
        ad_area.loadAd(adRequest)

        showTopFragment()
    }

    /**
     * TopFragment表示処理
     */
    fun showTopFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.main_contents, TopFragment())
        fragmentTransaction.commit()
    }
}