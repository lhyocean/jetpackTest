package com.bj.ocean.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bj.ocean.jetpack.R
import com.bj.ocean.jetpack.databinding.FragmentPlantListBinding
import com.google.gson.Gson

/**
 * Created by ocean on 2020-04-09
 * @describe:
 */
class PlanListFragment :Fragment(){

    companion object {
        fun newInstance() = PlanListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val binding=FragmentPlantListBinding.inflate(inflater, container,false)
            context?:return binding.root




        return binding.root
    }

}