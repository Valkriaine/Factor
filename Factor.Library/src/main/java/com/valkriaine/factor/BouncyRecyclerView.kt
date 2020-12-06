package com.valkriaine.factor

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.EdgeEffect
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.RecyclerView


class BouncyRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs)
{

    var overscrollAnimationSize = 0.5f

    var flingAnimationSize = 0.4f

    var currentVelocity = 0f

    val rc : RecyclerView

    val spring: SpringAnimation = SpringAnimation(this, SpringAnimation.TRANSLATION_Y)
        .setSpring(
            SpringForce()
                .setFinalPosition(0f)
                .setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_LOW)
        )
        .addUpdateListener { _, _, velocity -> currentVelocity = velocity }

    init {

        //read attributes
        context.theme.obtainStyledAttributes(attrs, R.styleable.BouncyRecyclerView, 0, 0)
            .apply{
            try {
                overscrollAnimationSize = getFloat(R.styleable.BouncyRecyclerView_overscroll_bounce_animation_size, 0.5f)
                flingAnimationSize = getFloat(R.styleable.BouncyRecyclerView_fling_bounce_animation_size, 0.5f)
            }
            finally
            {
                recycle()
            }
        }

        rc = this

        //create edge effect
        this.edgeEffectFactory = object : RecyclerView.EdgeEffectFactory()
        {
            override fun createEdgeEffect(recyclerView: RecyclerView, direction: Int): EdgeEffect
            {
                return object : EdgeEffect(recyclerView.context)
                {
                    override fun onPull(deltaDistance: Float)
                    {
                        super.onPull(deltaDistance)
                        onPullAnimation(deltaDistance)
                    }

                    override fun onPull(deltaDistance: Float, displacement: Float)
                    {
                        super.onPull(deltaDistance, displacement)
                        onPullAnimation(deltaDistance)
                    }

                    private fun onPullAnimation(deltaDistance: Float)
                    {
                        val delta =
                            if (direction == DIRECTION_BOTTOM)
                            -1 * recyclerView.width * deltaDistance * overscrollAnimationSize
                            else 1 * recyclerView.width * deltaDistance * overscrollAnimationSize
                        spring.cancel()
                        rc.translationY += delta
                    }

                    override fun onRelease()
                    {
                        super.onRelease()
                        spring.start()
                    }

                    override fun onAbsorb(velocity: Int)
                    {
                        super.onAbsorb(velocity)
                        val v =
                            if (direction == DIRECTION_BOTTOM) -1 * velocity * flingAnimationSize
                            else 1 * velocity * flingAnimationSize
                        spring.setStartVelocity(v).start()
                    }

                    override fun draw(canvas: Canvas?): Boolean
                    {
                        setSize(0, 0)
                        return super.draw(canvas)
                    }
                }
            }
        }
    }
}


