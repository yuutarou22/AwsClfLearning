package com.example.awsclflearning.Fragment.RamdomDaylyQuestionFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.awsclflearning.Model.Answer
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.fragment_ramdom_dayly_question02.*

class RamdomDaylyQuestionFragment02(_answers: List<Any>) : Fragment() {

    val answers = _answers
    lateinit var textViewList :List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ramdom_dayly_question02, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 選択肢を表示する
        textViewList = listOf(question_choice1, question_choice2, question_choice3, question_choice4)
        repeat(answers.size) {
            textViewList[it].text = (answers[it] as Answer).contents
        }
        super.onViewCreated(view, savedInstanceState)
    }
}