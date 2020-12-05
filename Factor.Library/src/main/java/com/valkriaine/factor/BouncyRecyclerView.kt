package com.valkriaine.factor

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.EdgeEffect
import androidx.recyclerview.widget.RecyclerView


class BouncyRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs)
{

    var overscrollAnimationSize = 0.5f

    var flingAnimationSize = 0.4f

    inline fun <reified T : ViewHolder> RecyclerView.forEachVisibleHolder(action: (T) -> Unit)
    {
        for (i in 0 until childCount)
        {
            action(getChildViewHolder(getChildAt(i)) as T)
        }

    }

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
                        handlePull(deltaDistance)
                    }

                    override fun onPull(deltaDistance: Float, displacement: Float)
                    {
                        super.onPull(deltaDistance, displacement)
                        handlePull(deltaDistance)
                    }

                    private fun handlePull(deltaDistance: Float)
                    {
                        val sign = if (direction == DIRECTION_BOTTOM) -1 else 1
                        val translationYDelta =
                            sign * recyclerView.width * deltaDistance * overscrollAnimationSize
                        recyclerView.forEachVisibleHolder { holder: BouncyViewHolder ->
                            holder.translationY.cancel()
                            holder.itemView.translationY += translationYDelta
                        }
                    }

                    override fun onRelease()
                    {
                        super.onRelease()
                        recyclerView.forEachVisibleHolder{ holder: BouncyViewHolder -> holder.translationY.start() }
                    }

                    override fun onAbsorb(velocity: Int)
                    {
                        super.onAbsorb(velocity)
                        val sign = if (direction == DIRECTION_BOTTOM) -1 else 1
                        val translationVelocity = sign * velocity * flingAnimationSize
                        recyclerView.forEachVisibleHolder { holder: BouncyViewHolder -> holder.translationY.setStartVelocity(translationVelocity).start() }
                    }

                    override fun draw(canvas: Canvas?): Boolean
                    {
                        //hide overscroll glow effect
                        setSize(0, 0)
                        return super.draw(canvas)
                    }
                }
            }
        }
    }
}


