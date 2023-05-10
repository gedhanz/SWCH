package com.example.aswitch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    var homeFragment: HomeFragment? = null
    var infoFragment: InfoFragment? = null
    var settingFragment: SettingFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeFragment = HomeFragment()
        infoFragment = InfoFragment()
        settingFragment = SettingFragment()
        supportFragmentManager.beginTransaction().replace(R.id.containers, homeFragment!!).commit()
        val navigationBarView = findViewById<NavigationBarView>(R.id.bottom_navigationview)
        navigationBarView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
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
}