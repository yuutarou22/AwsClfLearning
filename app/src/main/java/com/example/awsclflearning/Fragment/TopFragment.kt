package com.example.awsclflearning.Fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.awsclflearning.Adapter.RamdomDaylyQuestionAdapter
import com.example.awsclflearning.DepthPageTransformer
import com.example.awsclflearning.Fragment.RamdomDaylyQuestionFragments.RamdomDaylyQuestionFragment01
import com.example.awsclflearning.Fragment.RamdomDaylyQuestionFragments.RamdomDaylyQuestionFragment02
import com.example.awsclflearning.Fragment.RamdomDaylyQuestionFragments.RamdomDaylyQuestionFragment03
import com.example.awsclflearning.Model.QuestionModel
import com.example.awsclflearning.R
import com.example.awsclflearning.Util.FirebaseAnalyticsUtil.Companion.recordScreenView
import com.example.awsclflearning.Util.FirestoreUtil
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : BaseFragment(), OnClickListener, FirestoreUtil.DailyQuestionListener {

    private lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recordScreenView(getString(R.string.firebase_screen_name_top))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // FragmentでToolbarのMenuを管理するために実行。onCreateOptionMenuが呼び出される
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    /** ToolBarのオプション項目をセット **/
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu, menu)
    }

    /** ToolBarのオプションタップ時の処理 **/
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.settings -> {
            showFragment(SettingsFragment())
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_fragment_top)

        val firestoreUtil = FirestoreUtil()
        firestoreUtil.setDaylyQuestionListener(this)
        firestoreUtil.getDailyQuestion()

        // 後続処理は、onSuccessにて実行
    }

    fun setupIndicator() {
        random_daily_question_pager_indicator.setupWithViewPager(random_daily_question_pager, true)
        random_daily_question_pager_indicator.clearOnTabSelectedListeners()

        for (view in random_daily_question_pager_indicator.touchables) {
            view.isEnabled = false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ボタンの設定
        aws_practice_button.setOnClickListener(this)
        aws_learning_button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        // viewがNullでなければ実行される
        view?.let {
            when (view.id) {
                aws_practice_button.id -> {
                    showFragment(PracticeFragment())
                }
                aws_learning_button.id -> {
                    showFragment(LearningFragment())
                }
                else -> {}
            }
        }
    }

    override fun onSuccess(data: QuestionModel) {
        val fragmentList = createFragmentList(data)
        mPager = random_daily_question_pager
        val pagerAdapter = childFragmentManager?.let { RamdomDaylyQuestionAdapter(it, fragmentList) }
        mPager.setPageTransformer(true, DepthPageTransformer())
        mPager.adapter = pagerAdapter

        setupIndicator()
    }

    private fun createFragmentList(data: QuestionModel): ArrayList<Fragment> {
        return arrayListOf<Fragment>(
            RamdomDaylyQuestionFragment01(data.contents),
            RamdomDaylyQuestionFragment02(data.answers),
            RamdomDaylyQuestionFragment03(data.answers)
        )
    }
}