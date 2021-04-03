package com.example.awsclflearning.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.awsclflearning.R

class PracticeFragment : Fragment() {

    /** FragmentとActivityが紐付けられた時呼び出す(ContextはActivityと同義) */
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    /** Fragment生成時に呼び出す */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /** FragmentがUI描画時に呼び出す */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_practice, container, false)
    }

    /** FragmentのUI描画完了後に呼び出す */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /** FragmentとActivityの紐付けが解除された時呼び出す */
    override fun onDetach() {
        super.onDetach()
    }

    private fun initView() {

    }
}