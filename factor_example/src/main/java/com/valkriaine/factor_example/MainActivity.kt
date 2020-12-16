package com.valkriaine.factor_example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.valkriaine.factor.bouncyRecyclerViewUtil.OnOverPullListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataManager = DataManager()
        recycler_view.adapter = dataManager.adapter
        recycler_view.layoutManager = GridLayoutManager(this, 3)
        dataManager.generateData(150)
        background_layout.alpha = 0f

        val onOverPullListener = object : OnOverPullListener
        {
            override fun onOverPulledTop(deltaDistance: Float)
            {
                background_layout.alpha = background_layout.alpha + deltaDistance
                Log.d("pulled top", "delta: $deltaDistance")
            }

            override fun onOverPulledBottom(deltaDistance: Float)
            {
                Log.d("pulled bottom", "delta: $deltaDistance")
            }

            override fun onRelease()
            {
                background_layout.alpha = 0f
            }
        }


        recycler_view.addOnOverPulledListener(onOverPullListener)
    }
}
