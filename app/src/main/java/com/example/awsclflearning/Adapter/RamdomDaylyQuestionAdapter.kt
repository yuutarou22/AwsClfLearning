package com.example.awsclflearning.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class RamdomDaylyQuestionAdapter(fm: FragmentManager, private val fragmentList: List<Fragment>): FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

}