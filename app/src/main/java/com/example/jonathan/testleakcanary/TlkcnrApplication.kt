package com.example.jonathan.testleakcanary

import android.app.Application
import android.view.View

class TlkcnrApplication : Application() {
    public val leakedViews = mutableListOf<View>()
}