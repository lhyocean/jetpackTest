package com.bj.ocean.jetpack.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bj.ocean.jetpack.R
import com.bj.ocean.jetpack.data.Plant
import com.bj.ocean.jetpack.databinding.FragmentPlantDetailBinding
import com.bj.ocean.jetpack.utils.InjectUtils
import com.bj.ocean.jetpack.viewmodel.PlantDetailViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * Created by ocean on 2020-04-09
 * @describe:
 */
class PlantDetailFragment : Fragment() {


    private val args: PlantDetailFragmentArgs by navArgs()
    private val plantDetailViewModel: PlantDetailViewModel by viewModels {
        InjectUtils.providePlantDetailViewModelFactory(requireContext(), args.plantId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater,
            R.layout.fragment_plant_detail,
            container,
            false
        ).apply {
            viewModel = plantDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback {

                override fun add(plant: Plant?) {
                    plant?.let {
                        hideAppBarFab(fab)
                        plantDetailViewModel.addPlantToGarden()
                        Snackbar.make(root, "添加植物成功", Snackbar.LENGTH_SHORT).show()

                    }
                }
            }

            var isToolbarShown = false

            plantDetailScrollview.setOnScrollChangeListener(
                NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->

                    val shouldShowToolbar = scrollY > toolbar.height

                    if (isToolbarShown != shouldShowToolbar) {
                        isToolbarShown = shouldShowToolbar
                        appbar.isActivated = shouldShowToolbar
                        toolbarLayout.isTitleEnabled = shouldShowToolbar
                    }
                }
            )
            toolbar.setNavigationOnClickListener { v ->
                v.findNavController().navigateUp()
            }
            toolbar.setOnMenuItemClickListener {

                    item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        toShareIntent()
                        true
                    }
                    else -> false
                }
            }

        }

        return binding.root
    }

    private fun toShareIntent() {


    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behaviour = params.behavior as FloatingActionButton.Behavior
        behaviour.isAutoHideEnabled = false
        fab.hide()
    }


    interface Callback {

        fun add(plant: Plant?)
    }

}