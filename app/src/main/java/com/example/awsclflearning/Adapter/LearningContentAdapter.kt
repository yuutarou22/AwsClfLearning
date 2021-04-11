package com.example.awsclflearning.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.awsclflearning.R

class LearningContentAdapter(context: Context, _listGroup: List<String>, _listItem: List<List<String>>):
    BaseExpandableListAdapter() {
    /** メンバ変数 **/
    var listGroup: List<String> // 親要素のリスト
    var listItem: List<List<String>> // 子要素のリスト
    var context: Context

    override fun getGroupCount(): Int {
        return listGroup.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return listItem[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): Any {
        return listGroup[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return listItem[groupPosition][childPosition]
    }

    override fun getGroupId(p0: Int): Long {
        return 0
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return 0
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_group, parent, false)
        }

        val textView = convertView!!.findViewById<TextView>(R.id.list_group_title)
        textView.text = listGroup[groupPosition]
        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if(convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_item_learning, parent, false)
        }
        val textView = convertView!!.findViewById<TextView>(R.id.list_item_contents)
        textView.text = listItem[groupPosition][childPosition]
        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    init {
        this.context = context
        this.listGroup = _listGroup
        this.listItem = _listItem
    }
}