package com.bj.ocean.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bj.ocean.jetpack.R
import com.bj.ocean.jetpack.databinding.FragmentPlantDetailBinding

/**
 * Created by ocean on 2020-04-09
 * @describe:
 */
class PlantDetailFragment : Fragment() {

    companion object {
        fun newInstance() = PlantDetailFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater,
            R.layout.fragment_plant_detail,
            container,
            false
        )


        return binding.root
    }


}