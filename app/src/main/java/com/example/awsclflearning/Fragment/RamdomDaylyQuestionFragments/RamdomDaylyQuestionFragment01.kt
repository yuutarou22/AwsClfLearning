package com.example.awsclflearning.Fragment.RamdomDaylyQuestionFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.fragment_ramdom_dayly_question01.*

class RamdomDaylyQuestionFragment01(_contents: String) : Fragment() {

    val contents = _contents

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ramdom_dayly_question01, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        question_content.text = contents
        super.onViewCreated(view, savedInstanceState)
    }
}