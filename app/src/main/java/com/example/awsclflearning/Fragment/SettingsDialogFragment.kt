package com.example.awsclflearning.Fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class SettingsDialogFragment(val _message: String, val _array: Int, val _tag: String): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(_message)
                .setItems(_array, DialogInterface.OnClickListener{ dialog, which ->
                    if (_tag.equals("Font")) {
                        setFontSize(which)
                    }
                })
            builder.create()
        }
    }

    fun setFontSize(position: Int) {
        when (position) {
            0 -> {
                Log.d("TESTEST", "Font 大")
            }
            1 -> {
                Log.d("TESTEST", "Font 中")
            }
            2 -> {
                Log.d("TESTEST", "Font 小")
            }
            else -> {}
        }
    }
}