package com.example.awsclflearning.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.awsclflearning.Adapter.LearningContentAdapter
import com.example.awsclflearning.R
import kotlinx.android.synthetic.main.fragment_learning.*

class LearningFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 親グループの作成
        val group: MutableList<String> = ArrayList()
        group.add("基礎")
        group.add("AWSサービス")
        group.add("オススメ書籍")

        // 子グループの作成
        val item_group1: MutableList<String> = ArrayList()
        item_group1.add("Group1ーA")
        item_group1.add("Group2ーB")

        val item_group2: MutableList<String> = ArrayList()
        item_group2.add("Group2ーA")
        item_group2.add("Group2ーB")
        item_group2.add("Group2ーC")
        item_group2.add("Group2ーD")

        val item_group3: MutableList<String> = ArrayList()
        item_group3.add("Group3ーA")
        item_group3.add("Group3ーB")
        item_group3.add("Group3ーC")
        item_group3.add("Group3ーD")
        item_group3.add("Group3ーA2")
        item_group3.add("Group3ーB2")
        item_group3.add("Group3ーC2")
        item_group3.add("Group3ーD2")
        item_group3.add("Group3ーA3")
        item_group3.add("Group3ーB3")
        item_group3.add("Group3ーC3")
        item_group3.add("Group3ーD3")

        val items: MutableList<List<String>> = ArrayList()
        items.add(item_group1)
        items.add(item_group2)
        items.add(item_group3)

        // ExpandableListViewの初期化
        val adapter = context?.let { LearningContentAdapter(it, group, items) }
        expandable_list_view.setAdapter(adapter)

        // 子要素をタップしたときの処理
        expandable_list_view.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val adapter1 = parent.expandableListAdapter as LearningContentAdapter
            val groupName = adapter1.getGroup(groupPosition) as String
            val itemName = adapter1.getChild(groupPosition, childPosition) as String
            Toast.makeText(context, "$groupName : $itemName", Toast.LENGTH_SHORT).show()
            true
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_learning, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_fragment_learning)
    }
}