package com.example.awsclflearning.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.list_item_settings.view.*

class SettingContentAdapter(val _context: Context?, val _inflater: LayoutInflater, val _list:List<String>): BaseAdapter() {

    override fun getCount(): Int {
        return _list.size
    }

    override fun getItem(position: Int): Any {
        return _list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, _convertView: View?, parent: ViewGroup?): View {
        var convertedView = _convertView
        convertedView = _inflater.inflate(R.layout.list_item_settings, parent, false)
        convertedView.setting_title.text = _list.get(position)
        return convertedView
    }
}