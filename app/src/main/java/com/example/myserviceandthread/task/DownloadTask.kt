package com.example.myserviceandthread.task

import android.os.AsyncTask

/**
 * 核心
 * 1：doInBackground 中执行具体耗时任务
 * 2：onProgressUpdate 中进行UI操作
 * 3：onPostExecute 中执行任务收尾工作
 */
class DownloadTask : AsyncTask<Unit, Int, Boolean>() {

    // 任务执行之前要做的事情
    override fun onPreExecute() {
        super.onPreExecute()
    }

    // 子线程耗时任务放在这里 不可以进行UI操作
    override fun doInBackground(vararg params: Unit?): Boolean {
        return true
    }

    // 进度回调 后台任务调用publishProgress方法回调这里
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    // 任务执行完毕回调
    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
    }
}