package com.example.awsclflearning.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.awsclflearning.R
import com.example.awsclflearning.Util.FirebaseAnalyticsUtil

class PracticeFragment : Fragment() {

    /** FragmentとActivityが紐付けられた時呼び出す(ContextはActivityと同義) */
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    /** Fragment生成時に呼び出す */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_fragment_practice)
    }

    /** FragmentがUI描画時に呼び出す */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FirebaseAnalyticsUtil.recordScreenView(getString(R.string.firebase_screen_name_practice))
        return inflater.inflate(R.layout.fragment_practice, container, false)
    }

    /** FragmentのUI描画完了後に呼び出す */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /** FragmentとActivityの紐付けが解除された時呼び出す */
    override fun onDetach() {
        super.onDetach()
    }
}