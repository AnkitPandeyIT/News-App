package com.example.newsly

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class detail:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        var myWebView = findViewById<WebView>(R.id.detailwebView)
        var progressVar = findViewById<ProgressBar>(R.id.progressBar)

        val url = intent.getStringExtra("URL")
        if(url!=null){
            myWebView.settings.javaScriptEnabled = true
            myWebView.webViewClient = object :WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressVar.visibility = View.GONE
                    myWebView.visibility = View.VISIBLE
                }
            }
               myWebView.loadUrl(url)


        }
    }
}