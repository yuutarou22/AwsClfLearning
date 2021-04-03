package com.example.awsclflearning.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : BaseFragment(), OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // FragmentでToolbarのMenuを管理するために実行。onCreateOptionMenuが呼び出される
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    /** ToolBarのオプション項目をセット **/
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu, menu)
    }

    /** ToolBarのオプションタップ時の処理 **/
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.settings -> {
            showFragment(SettingsFragment())
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_fragment_top)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ボタンの設定
        aws_practice_button.setOnClickListener(this)
        aws_learning_button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        // viewがNullでなければ実行される
        view?.let {
            when (view.id) {
                aws_practice_button.id -> {
                    showFragment(PracticeFragment())
                }
                aws_learning_button.id -> {
                    showFragment(LearningFragment())
                }
                else -> {}
            }
        }
    }

}