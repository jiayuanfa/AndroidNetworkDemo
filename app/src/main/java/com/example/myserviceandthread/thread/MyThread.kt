package com.example.myserviceandthread.thread

import android.util.Log

class MyThread : Thread() {
    override fun run() {
        super.run()
        // 编写具体的逻辑
        Log.d("MyThread", "打印")
    }
}