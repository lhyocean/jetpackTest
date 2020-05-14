package com.bj.ocean.jetpack.adapters

import android.app.AlertDialog
import android.content.DialogInterface
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
import com.bj.ocean.jetpack.fragment.GardenFragment
import com.bj.ocean.jetpack.fragment.HomeViewPagerFragmentDirections
import com.bj.ocean.jetpack.utils.InjectUtils
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

        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_planted_garden, parent, false)
        )

    }

    class ViewHolder (
        private val binding: ItemPlantedGardenBinding

    ) : RecyclerView.ViewHolder(binding.root){


        fun bind(item: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(item,InjectUtils.getGardenPlantingRepository(itemView.context))
                executePendingBindings()
            }

        }
        init {
            binding.setClickListener {view ->
                binding.viewModel?.plantId?.let {
                    navigateToPlant(it, view)
                }
            }

            binding.setLongClickListener {
                  binding.viewModel?.plantId?.let {

                      longClick(it)
                  }
                 true
            }
        }

        private fun longClick(it: String) {

            AlertDialog.Builder(itemView.context)
                .setMessage("删除植物")
                .setTitle("plant")
                .setPositiveButton("确认", DialogInterface.OnClickListener { dialogInterface, i ->
                    binding.viewModel?.removDate(it)
                })
                .setNeutralButton("取消", null)
                .create()
                .show()
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