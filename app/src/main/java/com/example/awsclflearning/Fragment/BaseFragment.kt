package com.example.awsclflearning.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.awsclflearning.R

open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun showFragment(f: Fragment) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.replace(R.id.main_contents, f)
        fragmentTransaction?.commit()
    }
}