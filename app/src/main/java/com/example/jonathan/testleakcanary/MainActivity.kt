package com.example.jonathan.testleakcanary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import leakcanary.AppWatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Let's watch singleton variable "Utils.helper":
        AppWatcher.objectWatcher.expectWeaklyReachable(Utils.helper,
            "Explain why this object should be garbage collected soon")
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