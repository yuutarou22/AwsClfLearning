package com.example.awsclflearning.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.awsclflearning.Adapter.LearningContentAdapter
import com.example.awsclflearning.R
import com.github.kittinunf.fuel.core.requests.CancellableRequest
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result.Failure
import com.github.kittinunf.result.Result.Success
import kotlinx.android.synthetic.main.fragment_learning.*
import org.json.JSONException
import org.json.JSONObject

class LearningFragment : BaseFragment() {

    /** AWS学習コンテンツList **/
    // 親グループの作成
    val group: MutableList<String> = ArrayList()
    // 子グループの作成
    val item_group1: MutableList<String> = ArrayList()
    val item_group2: MutableList<String> = ArrayList()
    val item_group3: MutableList<String> = ArrayList()
    // 集約List
    val items: MutableList<List<String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val httpAsync = startLearningContentsJson()
        httpAsync.join()

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

            showFragment(LearningDetailContentsFragment())

            Toast.makeText(context, "$groupName : $itemName", Toast.LENGTH_SHORT).show()
            true
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_learning, container, false)
    }

    /** ToolBarのオプション項目をセット **/
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.learning_menu, menu)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_fragment_learning)
    }

    private fun startLearningContentsJson(): CancellableRequest {
        // Listの初期化
        clearLearningContentsList()

        val async = "https://aws-clf-learning-app.s3-ap-northeast-1.amazonaws.com/sample.json".httpGet().response { request, response, result ->
            when (result) {
                is Success -> {
                    try {
                        val jsonString = String(response.data)
                            .replace("\n","")
                            .replace("\t","")
                            .replace(" ","")
                            .replace("\uFEFF","")
                        val jsonObject = JSONObject(jsonString)
                        var learning_groups = jsonObject.getJSONArray("aws_learning_groups")
                        var learning_contents = jsonObject.getJSONArray("aws_learning_contents")

                        repeat(learning_groups.length()) {
                            Log.d("TEST ", "groups: ${learning_groups.getJSONObject(it).getString("title")}")
                            group.add(learning_groups.getJSONObject(it).getString("title"))
                        }

                        repeat(learning_contents.length()) {
                            val jsonObj = learning_contents.getJSONObject(it)
                            when (jsonObj.getInt("id")) {
                                1 -> {
                                    item_group1.add(jsonObj.getString("content_name"))
                                }
                                2 -> {
                                    item_group2.add(jsonObj.getString("content_name"))
                                }
                                3 -> {
                                    item_group3.add(jsonObj.getString("content_name"))
                                }
                                else -> {
                                    Log.d("LearningFragment", "content id not founded")
                                }
                            }
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                is Failure -> {
                    println("TEST 通信失敗")
                }
            }
        }
        return async
    }

    private fun clearLearningContentsList() {
        group.clear()
        item_group1.clear()
        item_group2.clear()
        item_group3.clear()
        items.clear()
    }
}