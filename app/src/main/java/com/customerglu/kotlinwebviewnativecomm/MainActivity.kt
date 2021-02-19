package com.customerglu.kotlinwebviewnativecomm

import android.content.Context
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO: Replace url with the url for your program/campaign.
    private val url = "<Provide-Your-campaign-url here>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exampleWebView.settings.javaScriptEnabled = true
        exampleWebView.addJavascriptInterface(JSComm(this),"app")
        exampleWebView.loadUrl(url)

    }

    /**
     * Receive message from webview
     */
    class JSComm(val context: Context){
        @JavascriptInterface
        fun callback(message:String){
            // Capture message from webview and print as toast
            Toast.makeText(context,message, Toast.LENGTH_LONG).show()
        }
    }

}