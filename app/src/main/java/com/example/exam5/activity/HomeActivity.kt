package com.example.exam5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.exam5.R
import com.example.exam5.adapter.CategoryAdapter
import com.example.exam5.adapter.ItemAdapter
import com.example.exam5.adapter.ViewPagerAdapterHome
import com.example.exam5.fragment.CollectionsFragment
import com.example.exam5.fragment.HomeFragment
import com.example.exam5.fragment.LastFragment
import com.example.exam5.fragment.MessagesFragment
import com.example.exam5.model.Category
import com.example.exam5.model.Item
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()
    }

    private fun initViews(){
        val viewPager = findViewById<ViewPager>(R.id.vp_viewpager)
        val tabLayout = findViewById<TabLayout>(R.id.tl_sliding_tabs)

        setViewPager(viewPager,tabLayout)
    }


    private fun setViewPager(viewPager:ViewPager, tabLayout : TabLayout){
        val adapter = ViewPagerAdapterHome(supportFragmentManager)
        adapter.add(HomeFragment())
        adapter.add(CollectionsFragment())
        adapter.add(MessagesFragment())
        adapter.add(LastFragment())

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        setIcons(tabLayout)
    }

    private fun setIcons(tabLayout:TabLayout){
        val icons= arrayListOf<Int>(
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_sort_24,
            R.drawable.ic2_outline_chat_bubble_outline_24,
            R.drawable.ic_baseline_search_24
        )

        tabLayout.getTabAt(0)?.setIcon(icons[0])
        tabLayout.getTabAt(1)?.setIcon(icons[1])
        tabLayout.getTabAt(2)?.setIcon(icons[2])
        tabLayout.getTabAt(3)?.setIcon(icons[3])
    }
}