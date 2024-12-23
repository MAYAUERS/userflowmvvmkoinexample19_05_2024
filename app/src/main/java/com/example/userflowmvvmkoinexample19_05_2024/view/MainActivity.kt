package com.example.userflowmvvmkoinexample19_05_2024.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.userflowmvvmkoinexample19_05_2024.R
import com.example.userflowmvvmkoinexample19_05_2024.model.UserData
import com.example.userflowmvvmkoinexample19_05_2024.viewmodel.UserViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userItemsAdapter: UserItemsAdapter
    private val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
               userViewModel.userFlow.collect{
                       userItemsAdapter = UserItemsAdapter(it as ArrayList<UserData>)
                       recyclerView.adapter = userItemsAdapter
               }
            }
        }

    }
}