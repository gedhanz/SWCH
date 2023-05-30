package com.example.aswitch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    var homeFragment: HomeFragment? = null //첫번쨰 화면 'HomeFragment' 이름 추후변경
    var infoFragment: InfoFragment? = null //두번쨰 화면
    var settingFragment: SettingFragment? = null //세번째 화면
    private val backKeyHandler: BackKeyHandler = BackKeyHandler(this) //BackKeyHandler 클래스 인스턴스 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeFragment = HomeFragment()
        infoFragment = InfoFragment()
        settingFragment = SettingFragment()
        supportFragmentManager.beginTransaction().replace(R.id.containers, homeFragment!!).commit() //초기화면 설정
        val navigationBarView = findViewById<NavigationBarView>(R.id.bottom_navigationview)
        navigationBarView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item -> //화면 교체 기능
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers,
                        homeFragment!!
                    )
                        .commit()
                    return@OnItemSelectedListener true
                }
                R.id.setting -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containers, settingFragment!!).commit()
                    return@OnItemSelectedListener true
                }
                R.id.info -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers,
                        infoFragment!!
                    )
                        .commit()
                    return@OnItemSelectedListener true
                }
            }
            false
        })
    }
    override fun onBackPressed() { //뒤로 가기 버튼을 두 번 눌러야 앱이 종료
        backKeyHandler.onBackPressed()
    }
}