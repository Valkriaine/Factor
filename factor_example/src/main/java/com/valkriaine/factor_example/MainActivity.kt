package com.valkriaine.factor_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
    }
}
