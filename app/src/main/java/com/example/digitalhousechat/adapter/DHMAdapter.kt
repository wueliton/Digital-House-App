package com.example.digitalhousechat.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.digitalhousechat.activity.MainActivity

class DHMAdapter(
    private val fragmentList: List<Fragment>,
    fa: MainActivity
): FragmentStateAdapter(fa) {
    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}