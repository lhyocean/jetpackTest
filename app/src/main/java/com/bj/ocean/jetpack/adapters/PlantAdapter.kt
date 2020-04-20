package com.bj.ocean.jetpack.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bj.ocean.jetpack.data.Plant
import com.bj.ocean.jetpack.databinding.ListItemPlantBinding
import com.bj.ocean.jetpack.fragment.HomeViewPagerFragmentDirections

/**
 * Created by ocean on 2020-04-17
 * @describe:
 */
class PlantAdapter : ListAdapter<Plant, RecyclerView.ViewHolder>(PlantDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return PlantViewHolder(ListItemPlantBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant=getItem(position)
        (holder as PlantViewHolder).bind(plant)
    }


    class PlantViewHolder (
        private val binding: ListItemPlantBinding

    ): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.plant?.let { plant ->
                    navigateToPlant(plant,it)
                }
            }
        }
        private fun navigateToPlant(plant: Plant, view: View) {

            val direction =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plant.plantId)
            view.findNavController().navigate(direction)
        }
        fun bind(item: Plant?) {

            binding.apply {
                plant=item
                executePendingBindings()
            }
        }
    }

    private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.plantId == newItem.plantId
        }


    }

}