package com.example.aswitch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.hide()

        moveMain(2) // 1초 후 main activity로 넘어감
    }
    private fun moveMain(sec: Int) {
        Handler().postDelayed({
            // Intent(현재 context, 이동할 activity)
            val intent = Intent(applicationContext, MainActivity::class.java)

            startActivity(intent) // intent에 명시된 액티비티로 이동

            finish() // 현재 액티비티 종료
        }, 1000 * sec.toLong()) // sec초 정도 딜레이를 준 후 시작
    }
}