package com.example.awsclflearning.Fragment

import android.content.Context
import android.content.Intent
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
import android.widget.Toast
import com.example.awsclflearning.Adapter.SettingContentAdapter
import com.example.awsclflearning.R
import com.example.awsclflearning.Util.FirebaseAnalyticsUtil.Companion.recordScreenView
import com.example.awsclflearning.Util.SharedPreferencesEditor
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.list_item_settings.*

class SettingsFragment : BaseFragment(), OnItemClickListener {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_fragment_settings)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recordScreenView(getString(R.string.firebase_screen_name_settings))
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
        val settingContentsList = createSettingsContentList()
        var settingAdapter = SettingContentAdapter(context, context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater, settingContentsList)
        settings_list_view.adapter = settingAdapter
        settings_list_view.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("TESTEST", "SettingFragment position: ${position}")

        when (position) {
            0 -> {
                var sp = SharedPreferencesEditor(context!!, "Settings")
                if (setting_switch.isChecked) {
                    Toast.makeText(context, getString(R.string.settings_dark_mode_off), Toast.LENGTH_SHORT).show()
                    setting_switch.isChecked = false
                    sp.setDarkMode(false)
                    context!!.setTheme(R.style.MainTheme_Default)
                } else {
                    Toast.makeText(context, getString(R.string.settings_dark_mode_on), Toast.LENGTH_SHORT).show()
                    setting_switch.isChecked = true
                    sp.setDarkMode(true)
                    context!!.setTheme(R.style.MainTheme_Dark)
                }
            }
            1 -> {
                // フォントサイズ
                val dialog = SettingsDialogFragment("フォントサイズを選んでください。", R.array.settings_font_size, "Font")
                dialog.show(fragmentManager!!, "Settings")
            }
            2 -> {
                // プライバシーポリシー
            }
            3 -> {
                // アプリバージョン
            }
            4 -> {
                // ライセンス
            }
            5 -> {
                // 友だちにすすめる
                chooseShare()
            }
            else -> {}
        }
    }

    fun chooseShare() {
        var intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, "共有テストテストテスト https://jp.techcrunch.com/2021/04/13/2021-04-12-twitter-to-set-up-its-first-african-presence-in-ghana/")
        startActivity(Intent.createChooser(intent, "共有方法を選んでください。"))
    }

    fun createSettingsContentList(): List<String> {
        return listOf<String>(
            getString(R.string.settings_content_dark_mode),
            getString(R.string.settings_content_font_size),
            getString(R.string.settings_content_privacy_policy),
            getString(R.string.settings_content_app_ver),
            getString(R.string.settings_content_license),
            getString(R.string.settings_content_recommend),
            getString(R.string.settings_content_review))
    }
}