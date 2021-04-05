package com.example.awsclflearning.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.awsclflearning.R

class LearningDetailContentsFragment : BaseFragment() {

    var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_learning_detail_contents, container, false)
    }

    /** ToolBarのオプション項目をセット **/
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.learning_detail_contents_menu, menu)
    }

    /** ToolBarのオプションタップ時の処理 **/
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.favorite -> {
            if (!isFavorite) {
                item.setIcon(R.drawable.ic_baseline_star_24)
                isFavorite = true
            } else {
                item.setIcon(R.drawable.ic_baseline_star_outline_24)
                isFavorite = false
            }
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}