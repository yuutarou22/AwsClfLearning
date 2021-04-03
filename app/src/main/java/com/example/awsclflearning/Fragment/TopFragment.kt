package com.example.awsclflearning.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aws_practice_button.setOnClickListener {
            showFragment(PracticeFragment())
        }

        aws_learning_button.setOnClickListener {
            showFragment(LearningFragment())
        }

        settings_button.setOnClickListener {
            showFragment(SettingsFragment())
        }
    }

}