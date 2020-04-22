package com.bj.ocean.jetpack.adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

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


@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Log.e("BindingAdapter",imageUrl+"0000")
        Glide.with(view.context)
            .setDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade()).into(view)
    }



}


