package com.bj.ocean.jetpack.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bj.ocean.jetpack.R
import com.bj.ocean.jetpack.data.PlantAndGardenPlantings
import com.bj.ocean.jetpack.databinding.ItemPlantedGardenBinding
import com.bj.ocean.jetpack.fragment.HomeViewPagerFragmentDirections
import com.bj.ocean.jetpack.viewmodel.PlantAndGardenPlantingsViewModel

/**
 * Created by ocean on 2020-04-27
 * @describe:
 */
class GardenPlantingAdapter :
    ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(
        GardenPlantDiffCallback()
    ) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_planted_garden, parent, false))

    }

    class ViewHolder(
        private val binding: ItemPlantedGardenBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(item)
                executePendingBindings()
            }
        }

        init {

            binding.setClickListener {view ->
                binding.viewModel?.plantId?.let {
                    navigateToPlant(it, view)
                }
            }
        }

        private fun navigateToPlant(plantId: String, it: View ){
            val direction = HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plantId)
            it.findNavController().navigate(direction)

        }

    }

    class GardenPlantDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {

        override fun areContentsTheSame(oldItem: PlantAndGardenPlantings, newItem: PlantAndGardenPlantings): Boolean {

            return oldItem.plant == newItem.plant
        }

        override fun areItemsTheSame(oldItem: PlantAndGardenPlantings, newItem: PlantAndGardenPlantings): Boolean {

            return oldItem.plant.plantId == newItem.plant.plantId
        }
    }


}