package com.bj.ocean.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.viewpager2.widget.ViewPager2
import com.bj.ocean.jetpack.R
import com.bj.ocean.jetpack.adapters.GardenPlantingAdapter
import com.bj.ocean.jetpack.adapters.PLANT_LIST_PAGE_INDEX
import com.bj.ocean.jetpack.databinding.FragmentGardenBinding
import com.bj.ocean.jetpack.utils.InjectUtils
import com.bj.ocean.jetpack.viewmodel.GardenPlantingListViewModel

/**
 * Created by ocean on 2020-04-09
 * @describe:
 */
class GardenFragment : Fragment() {

    private lateinit var binding: FragmentGardenBinding

    private val viewModel: GardenPlantingListViewModel by viewModels {
        InjectUtils.provideGardenPlantingListViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentGardenBinding.inflate(inflater,container,false)
        val adapter=GardenPlantingAdapter()
        binding.gardenList.adapter=adapter
        binding.addPlant.setOnClickListener{
            navigateToPlantListPage()
        }
        subscribeUi(binding,adapter)
        return binding.root
    }

    private fun navigateToPlantListPage() {

        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem= PLANT_LIST_PAGE_INDEX
    }

    private fun subscribeUi(binding: FragmentGardenBinding, adapter: GardenPlantingAdapter) {
        viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner){
            result->
            binding.hasPlants= !result.isNullOrEmpty()
            adapter.submitList(result)
        }

    }

}