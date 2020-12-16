package com.valkriaine.factor.bouncyRecyclerViewUtil

interface OnOverPullListener
{
    fun onOverPulledTop(deltaDistance: Float)

    fun onOverPulledBottom(deltaDistance: Float)

    fun onRelease()
}