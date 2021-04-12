package com.example.awsclflearning.Fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import com.example.awsclflearning.Adapter.SettingContentAdapter
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_fragment_settings)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.settings_save -> {
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListView()
    }

    fun setupListView() {
        val settingContentsList = listOf<String>("ダークモード", "フォントサイズ", "プライバシーポリシー", "アプリバージョン", "ライセンス", "友だちにススめる")
        var settingAdapter = SettingContentAdapter(context, context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater, settingContentsList)
        settings_list_view.adapter = settingAdapter
        settings_list_view.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("TESTEST", "SettingFragment position: ${position}")
    }
}