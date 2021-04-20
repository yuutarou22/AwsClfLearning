package com.example.awsclflearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.awsclflearning.Fragment.TopFragment
import com.example.awsclflearning.Util.SharedPreferencesEditor
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initTheme()

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
        fragmentTransaction.replace(R.id.main_contents, TopFragment())
        fragmentTransaction.commit()
    }

    /**
     * テーマ（Theme）の初期処理
     */
    fun initTheme() {
        var sp = SharedPreferencesEditor(this, "Settings")
        if (sp.getDarkMode()) {
            setTheme(R.style.MainTheme_Dark)
        } else {
            setTheme(R.style.MainTheme_Default)
        }
    }
}