package com.example.jonathan.testleakcanary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import leakcanary.AppWatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example 1: Let's watch singleton variable "Utils.helper":
        AppWatcher.objectWatcher.expectWeaklyReachable(Utils.helper,
            "Explain why this object should be garbage collected soon")

        // Example 2:
        val textView = findViewById<View>(R.id.helper_text)

        val app = application as TlkcnrApplication

        // "textView" is referenced elsewhere and can't be garbage-collected even though
        // this Activity object is ready to be destroyed:
        app.leakedViews.add(textView)
    }

    override fun onStart() {
        Log.d(TAG, "onCreate")

        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")

        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")

        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")

        super.onDestroy()
    }

    companion object {
        private const val TAG = "TLKCNR: MainActivity"
    }
}