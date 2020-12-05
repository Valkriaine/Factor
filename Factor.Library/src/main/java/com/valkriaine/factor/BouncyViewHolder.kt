package com.valkriaine.factor

import android.view.View
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.RecyclerView

open class BouncyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var currentVelocity = 0f

    val translationY: SpringAnimation = SpringAnimation(itemView, SpringAnimation.TRANSLATION_Y)
        .setSpring(
                SpringForce()
                .setFinalPosition(0f)
                .setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_LOW)
        )
        .addUpdateListener { _, _, velocity -> currentVelocity = velocity }
}