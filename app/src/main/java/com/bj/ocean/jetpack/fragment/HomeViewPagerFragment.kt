package com.bj.ocean.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bj.ocean.jetpack.databinding.FragmentViewPagerBinding

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

        viewpager.adapter=





        return binding.root
    }


}