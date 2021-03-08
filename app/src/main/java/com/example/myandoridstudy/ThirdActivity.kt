package com.example.myandoridstudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

private const val NUM_PAGES = 2

class ThirdActivity : FragmentActivity() {
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        viewPager2 = findViewById(R.id.pager)

        val pagerAdapter = SlidePagerAdapter(this)
        viewPager2.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (viewPager2.currentItem == 0){
            super.onBackPressed()
        }else{
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }

    private inner class SlidePagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
        override fun getItemCount(): Int = NUM_PAGES
        override fun createFragment(position: Int): Fragment{
            return when (position) {
                0 -> FirstFragment()
                1 -> SecondFragment()
                else -> FirstFragment()
            }
        }
    }
}