package com.valkriaine.factor_example

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataManager = DataManager()
        recycler_view.adapter = dataManager.adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        dataManager.generateData(100)

    }
}
