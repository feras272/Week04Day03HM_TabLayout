package com.example.week04day03hm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var tabLayout:TabLayout? = null
    private var viewPager:ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectView()
        prepareTabs()
    }

    private fun connectView() {
        tabLayout = findViewById(R.id.activity_main_tab_layout)
        viewPager = findViewById(R.id.activity_main_view_pager_screen)
    }

    private fun prepareTabs() {
        val fragmentAdapter:FragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle)
        fragmentAdapter.addFragment(HomeFragment(),"HOME")
        fragmentAdapter.addFragment(ProfileFragment(),"PROFILE")
        fragmentAdapter.addFragment(SettingFragment(), "SETTING")

        viewPager?.adapter = fragmentAdapter

        TabLayoutMediator(tabLayout!!, viewPager!!) { tab, position ->
            tab.text = fragmentAdapter.fragmentTitles[position]
        }.attach()
    }
}