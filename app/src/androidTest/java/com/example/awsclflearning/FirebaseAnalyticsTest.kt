package com.example.awsclflearning

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FirebaseAnalyticsTest {
    val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun recordScreenTestTop() {
        Assert.assertEquals("トップ", appContext.getString(R.string.firebase_screen_name_top))
    }

    @Test
    fun recordScreenTestSettings() {
        Assert.assertEquals("設定", appContext.getString(R.string.firebase_screen_name_settings))
    }

    @Test
    fun recordScreenTestLearning() {
        Assert.assertEquals("AWS学習", appContext.getString(R.string.firebase_screen_name_aws_learning))
    }

    @Test
    fun recordScreenTestLearningDetail() {
        Assert.assertEquals(
            "AWS学習 詳細", appContext.getString(R.string.firebase_screen_name_aws_learning_detail)
        )
    }

    @Test
    fun recordScreenTestPractice() {
        Assert.assertEquals("練習問題", appContext.getString(R.string.firebase_screen_name_practice))
    }
}