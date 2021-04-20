package com.example.awsclflearning.Fragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.awsclflearning.R
import com.github.kittinunf.result.Result.Success
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result.Failure
import kotlinx.android.synthetic.main.fragment_learning_detail_contents.*

class LearningDetailContentsFragment(
    _learningTitle: String,
    _learningContent: String,
    _learningContentImageUrl: String
) : BaseFragment() {

    val learningTitle = _learningTitle
    val learningContent = _learningContent
    val learningContentImageUrl = _learningContentImageUrl
    var isFavorite: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_learning_detail_contents, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (learningContent.contains("https://")) {
            learning_scroll_view.visibility = View.GONE
            webview.loadUrl(learningContent)
            webview.setWebViewClient(object: WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return false
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    loading_progress_bar.visibility = View.VISIBLE
                }
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    loading_progress_bar.visibility = View.GONE
                }
            })
        } else {
            webview.visibility = View.GONE
            learning_title.text = learningTitle
            learning_content.text = learningContent

            setupLearningContentImage()
        }
    }

    /** ToolBarのオプション項目をセット **/
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.learning_detail_contents_menu, menu)
    }

    /** ToolBarのオプションタップ時の処理 **/
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.favorite -> {
            if (!isFavorite) {
                item.setIcon(R.drawable.ic_baseline_star_24)
                isFavorite = true
            } else {
                item.setIcon(R.drawable.ic_baseline_star_outline_24)
                isFavorite = false
            }
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun setupLearningContentImage() {

        // UrlがNullか空文字の場合はNoImage
        if (learningContentImageUrl.isNullOrEmpty()) {
            learning_content_img.setImageResource(R.drawable.no_img)
            return
        }

        val async = learningContentImageUrl.httpGet().response { request, response, result ->
            when (result) {
                is Success -> {
                    val bitmap = BitmapFactory.decodeStream(response.body().toStream())
                    learning_content_img.setImageBitmap(bitmap)
                }
                is Failure -> {
                    // Urlが不正で画像取得できない場合はNoImage
                    learning_content_img.setImageResource(R.drawable.no_img)
                }
            }
        }
        async.join()
    }
}