package com.example.awsclflearning.Util

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class FirebaseAnalyticsUtil {

    companion object {

        private val firebaseAnalytics: FirebaseAnalytics = Firebase.analytics

        fun recordScreenView(screenName: String) {
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
            }
        }
    }
}