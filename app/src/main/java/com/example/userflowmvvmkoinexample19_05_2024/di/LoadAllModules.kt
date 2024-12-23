package com.example.userflowmvvmkoinexample19_05_2024.di

import org.koin.core.context.loadKoinModules

object LoadAllModules {

    fun init() = loadKoinModules(listOf(networkModule,appModule))
}