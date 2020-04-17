package com.bj.ocean.jetpack.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * Created by ocean on 2020-04-13
 *
 *
 *
 *
 *
 * @describe:
 */

@BindingAdapter("app:isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    if (isGone) view.visibility = View.GONE else view.visibility = View.VISIBLE
}


@BindingAdapter("app:imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade()).into(view)
    }

}


