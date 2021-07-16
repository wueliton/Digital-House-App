package com.example.digitalhousechat.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitalhousechat.adapter.DHMAdapter
import com.example.digitalhousechat.databinding.ActivityMainBinding
import com.example.digitalhousechat.fragment.Calls
import com.example.digitalhousechat.fragment.Conversations
import com.example.digitalhousechat.fragment.Status
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(Conversations(), Status(), Calls())
        val titles = listOf("Conversas", "Status", "Chamadas")
        val dhmViewPager = DHMAdapter(fragments, this)

        binding.vpViews.adapter = dhmViewPager

        TabLayoutMediator(binding.tlMenu, binding.vpViews) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}