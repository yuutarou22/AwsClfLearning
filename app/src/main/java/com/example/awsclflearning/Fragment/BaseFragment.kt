package com.example.awsclflearning.Fragment

import androidx.fragment.app.Fragment
import com.example.awsclflearning.R

open class BaseFragment : Fragment() {

    protected fun showFragment(f: Fragment) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.replace(R.id.main_contents, f)
        fragmentTransaction?.commit()
    }
}