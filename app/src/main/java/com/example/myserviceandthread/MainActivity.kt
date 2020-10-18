package com.example.myserviceandthread

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.myserviceandthread.task.DownloadTask
import com.example.myserviceandthread.thread.MyThread
import com.example.myserviceandthread.thread.MyThread1
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val updateText = 1
    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                updateText -> {
                    contentTv.text = "Nice to meet you"
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        threadTest()

        handler()

        DownloadTask().execute()
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }

    private fun handler() {
        updateBtn.setOnClickListener {
            thread {
                val msg = Message()
                msg.what = updateText
                handler.sendMessage(msg)
            }
        }
    }

    private fun threadTest() {
        // 方式一
        MyThread().start()

        // 方式二
        Thread(MyThread1()).start()

        // 方式三
        Thread {
            // 具体逻辑
        }.start()

        // 方式四
        thread {

        }
    }
}