package com.bj.ocean.jetpack.adapters

import android.view.View
import androidx.databinding.BindingAdapter

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
