package com.example.awsclflearning.Util

import android.content.Context

class SharedPreferencesEditor(val _context: Context, val _mode: String) {

    fun setDarkMode(isDarkMode: Boolean) {
        if (_mode.equals("Settings")) {
            val sp = _context.getSharedPreferences("Settings_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putBoolean("DarkMode", isDarkMode)
            editor.apply()
        } else {
            return
        }
    }

    fun getDarkMode(): Boolean {
        if (_mode.equals("Settings")) {
            val sp = _context.getSharedPreferences("Settings_sp", Context.MODE_PRIVATE)
            return sp.getBoolean("DarkMode", false)
        } else {
            return false
        }
    }
}