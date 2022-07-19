package com.example.week04day03hm

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentManager:FragmentManager, lifecycle:Lifecycle) : FragmentStateAdapter(
    fragmentManager, lifecycle
){
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    val fragmentList:ArrayList<Fragment> = ArrayList()
    val fragmentTitles:ArrayList<String> = ArrayList()

    fun addFragment(fragment:Fragment, tag:String) {
        fragmentList.add(fragment)
        fragmentTitles.add(tag)
    }
}