package com.bj.ocean.jetpack.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bj.ocean.jetpack.fragment.GardenFragment
import com.bj.ocean.jetpack.fragment.PlanListFragment
import java.lang.IndexOutOfBoundsException


/**
 * Created by ocean on 2020/4/15.
 */
const val MY_GARDEN_PAGE_INDEX=0
const val PLANT_LIST_PAGE_INDEX=1



class SunflowerPagerAdapter (fragment: Fragment):FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return tabFragmentCreators.size
        //To change body of created functions use File | Settings | File Templates.
    }

    /**
     *    mapOf 方法 创建不可变集合
     */
    private val tabFragmentCreators:Map<Int,()->Fragment> =mapOf(
            MY_GARDEN_PAGE_INDEX to {GardenFragment()},
            PLANT_LIST_PAGE_INDEX to {PlanListFragment()}
    )


    override fun createFragment(position: Int): Fragment {

        return tabFragmentCreators[position]?.invoke()?:throw IndexOutOfBoundsException()

    }
}