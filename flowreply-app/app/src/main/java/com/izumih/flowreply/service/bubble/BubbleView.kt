package com.izumih.flowreply.service.bubble

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.izumih.flowreply.R

/**
 * The floating bubble: a circular Material-styled button that hosts the app
 * icon. Drawn programmatically so it needs no inflated layout.
 */
class BubbleView(context: Context) : ImageView(context) {

    init {
        val sizePx = dp(56)
        val padding = dp(14)
        layoutParams = android.view.ViewGroup.LayoutParams(sizePx, sizePx)
        setPadding(padding, padding, padding, padding)

        background = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(ContextCompat.getColor(context, R.color.bubble_background))
            setStroke(dp(1), ContextCompat.getColor(context, R.color.bubble_outline))
        }
        elevation = dp(6).toFloat()
        setImageResource(R.drawable.ic_bubble)
        imageTintList = android.content.res.ColorStateList.valueOf(
            ContextCompat.getColor(context, R.color.bubble_foreground),
        )
        isClickable = true
        contentDescription = context.getString(R.string.bubble_content_description)
    }

    private fun dp(value: Int): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), resources.displayMetrics,
    ).toInt()
}
