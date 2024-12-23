package com.example.userflowmvvmkoinexample19_05_2024.network

import com.example.userflowmvvmkoinexample19_05_2024.model.UserData
import retrofit2.http.GET

interface ApiService {
//https://jsonplaceholder.typicode.com/users
    @GET("users")
    suspend fun getUserList() :List<UserData>
}