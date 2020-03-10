package com.example.pyxis

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_web.*
import java.util.Collections.max
import java.util.Collections.min

class WebActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        editText = findViewById(R.id.edturl) as EditText

        webView = findViewById(R.id.webview) as WebView

        webview.webViewClient = MyWebViewClient()

        btnGo.setOnClickListener {
            var t_url = "https://www.google.com/search?q=".plus(editText.text.toString())
            webView.loadUrl(t_url)
            edturl.setText(t_url)
        }

        btnRefresh.setOnClickListener {
            webView.reload()
        }

        btnBack.setOnClickListener {
            webView.goBack()
            edturl.setText(webView.originalUrl.toString())
        }

        btnNext.setOnClickListener {
            webView.goForward()
            edturl.setText(webView.originalUrl.toString())
        }

    }

    class MyWebViewClient : WebViewClient(){
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
        view?.loadUrl(request?.url.toString())
        return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}

