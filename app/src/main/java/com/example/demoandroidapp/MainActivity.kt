package com.example.demoandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val data = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val prefetchAdapter = PrefetchAdapter()
        prefetchAdapter.setData(data)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
            adapter = prefetchAdapter
        }

    }
}