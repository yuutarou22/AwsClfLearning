package com.example.awsclflearning.Fragment.RamdomDaylyQuestionFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.awsclflearning.Model.Answer
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.fragment_ramdom_dayly_question03.*

class RamdomDaylyQuestionFragment03(_answers: List<Any>) : Fragment() {
    val answers = _answers

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ramdom_dayly_question03, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        repeat(answers.size) {
            if ((answers[it] as Answer).isAnswer) {
                answer_content.text = (it + 1).toString()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }
}