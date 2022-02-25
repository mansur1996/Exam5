package com.example.exam5.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.exam5.R
import com.example.exam5.adapter.ViewPagerAdapter
import com.example.exam5.fragment.AddFragment
import com.example.exam5.fragment.ChatFragment
import com.example.exam5.fragment.GetFragment
import com.example.exam5.fragment.SavedFragment
import com.example.exam5.SharedPref
import me.relex.circleindicator.CircleIndicator

class MainActivity : AppCompatActivity() , ViewPager.OnPageChangeListener {

    private lateinit var tvSkip : TextView
    private lateinit var tvNext : TextView
    private lateinit var tvDone : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(SharedPref(this).isSaved){
            Intent(applicationContext, HomeActivity::class.java).also {
                startActivity(it)
            }
        }

        initViews()
    }

    private fun initViews(){
        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        val circleIndicator = findViewById<CircleIndicator>(R.id.ci_circle_indicator)
        tvSkip = findViewById(R.id.tv_skip)
        tvNext = findViewById(R.id.tv_next)
        tvDone = findViewById(R.id.tv_done)

        setViewPager(viewPager, circleIndicator)

        tvSkip.setOnClickListener {
            viewPager.currentItem = 4
            tvSkip.visibility = View.GONE
            tvNext.visibility = View.GONE
            tvDone.visibility = View.VISIBLE
        }

        tvNext.setOnClickListener {
            if(viewPager.currentItem + 1 == 3){
                tvSkip.visibility = View.GONE
                tvNext.visibility = View.GONE
                tvDone.visibility = View.VISIBLE
                viewPager.currentItem = viewPager.currentItem + 1
            }else{
                viewPager.currentItem = viewPager.currentItem + 1
            }
        }

        tvDone.setOnClickListener {
            SharedPref(this).isSaved = true

            openHomeActivity()
            finish()
        }
    }

    private fun openHomeActivity(){
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun setViewPager(vp : ViewPager, circleIndicator: CircleIndicator){
        vp.setOnPageChangeListener(this)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.add(SavedFragment())
        adapter.add(AddFragment())
        adapter.add(ChatFragment())
        adapter.add(GetFragment())

        vp.adapter = adapter

        circleIndicator.setViewPager(vp)
        adapter.registerDataSetObserver(circleIndicator.dataSetObserver)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.d("@@@", "onPageScrolled")
    }

    override fun onPageSelected(position: Int) {
        if(position == 3){
            tvSkip.visibility = View.GONE
            tvNext.visibility = View.GONE
            tvDone.visibility = View.VISIBLE

        }else{
            tvDone.visibility = View.GONE
            tvSkip.visibility = View.VISIBLE
            tvNext.visibility = View.VISIBLE
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
        Log.d("@@@", "onPageScrollStateChanged")
    }
}