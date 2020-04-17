package com.bj.ocean.jetpack

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.ShapeAppearancePathProvider


/**
 * Created by ocean on 2020-04-17
 * @describe:
 */
class MaskedCardView(
    context: Context,
    attributes: AttributeSet? = null,
    defstyle: Int = R.attr.materialCardViewStyle
) : MaterialCardView(context, attributes, defstyle) {
    @SuppressLint("RestrictedApi")
    private val pathProvider = ShapeAppearancePathProvider()
    private val path: Path = Path()
    private val shapeAppearance: ShapeAppearanceModel = ShapeAppearanceModel(
        context,
        attributes,
        defstyle,
        com.google.android.material.R.style.Widget_MaterialComponents_CardView
    )
    private val rectF = RectF(0f, 0f, 0f, 0f)

    override fun onDraw(canvas: Canvas) {
        canvas.clipPath(path)
        super.onDraw(canvas)
    }

    @SuppressLint("RestrictedApi")
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        rectF.right = w.toFloat()
        rectF.bottom = h.toFloat()
        pathProvider.calculatePath(shapeAppearance, 1f, rectF, path)
        super.onSizeChanged(w, h, oldw, oldh)
    }


}
