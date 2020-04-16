package com.bj.ocean.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bj.ocean.jetpack.R
import com.bj.ocean.jetpack.adapters.MY_GARDEN_PAGE_INDEX
import com.bj.ocean.jetpack.adapters.PLANT_LIST_PAGE_INDEX
import com.bj.ocean.jetpack.adapters.SunflowerPagerAdapter
import com.bj.ocean.jetpack.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * Created by ocean on 2020-04-09
 * @describe:
 */
class HomeViewPagerFragment :Fragment(){

    companion object {
        fun newInstance() = HomeViewPagerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding=FragmentViewPagerBinding.inflate(inflater,container,false)
        val tabLayout=binding.tabs
        val viewpager=binding.viewPager

        viewpager.adapter=SunflowerPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewpager){
            tab, position ->

            tab.setIcon(getTabIcon(position))
            tab.text=getTabText(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)


        return binding.root
    }

    private fun getTabText(position: Int): CharSequence? {
        return when (position){
            MY_GARDEN_PAGE_INDEX ->getString(R.string.my_garden_title)
            PLANT_LIST_PAGE_INDEX ->getString(R.string.plant_list_title)
            else ->throw IndexOutOfBoundsException()
        }

    }

    private fun getTabIcon(position: Int): Int {

        return when (position){
            MY_GARDEN_PAGE_INDEX ->R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX ->R.drawable.plant_list_tab_selector
            else ->throw IndexOutOfBoundsException()
        }
    }


}