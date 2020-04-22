package com.bj.ocean.jetpack.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.bj.ocean.jetpack.R
import com.bj.ocean.jetpack.adapters.PlantAdapter
import com.bj.ocean.jetpack.data.AppDatabase
import com.bj.ocean.jetpack.data.PlantRepository
import com.bj.ocean.jetpack.databinding.FragmentPlantListBinding
import com.bj.ocean.jetpack.utils.InjectUtils
import com.bj.ocean.jetpack.viewmodel.PlantListViewModel

/**
 * Created by ocean on 2020-04-09
 * @describe:
 */
class PlanListFragment :Fragment(){


    private val viewModel:PlantListViewModel by viewModels {
        InjectUtils.providePLantListViewModelFactory(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val binding=FragmentPlantListBinding.inflate(inflater, container,false)
            context?:return binding.root

          val adapter=PlantAdapter()
          binding.plantList.adapter=adapter

          subscribeView(adapter)
          setHasOptionsMenu(true)
          return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_plant_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){

            R.id.filter_zone -> {
                updateData()
                true
            }
            else ->super.onOptionsItemSelected(item)
        }

    }

    private fun updateData() {
        if (viewModel.isFiltered()){
            viewModel.clearGrowZoneNumber()
        }else{
            viewModel.setGrowZoneNumber(9)
        }

    }

    private fun subscribeView(adapter: PlantAdapter) {
        viewModel.plants.observe(viewLifecycleOwner){
                adapter.submitList(it)
        }
    }


}