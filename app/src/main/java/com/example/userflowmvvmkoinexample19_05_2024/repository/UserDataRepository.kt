package com.example.userflowmvvmkoinexample19_05_2024.repository

import com.example.userflowmvvmkoinexample19_05_2024.model.UserData
import com.example.userflowmvvmkoinexample19_05_2024.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


class UserDataRepository(private val apiService: ApiService) {

    suspend fun getUserListData():Flow<Result<List<UserData>>> = flow {
        try {
            val user = apiService.getUserList()
            emit(Result.success(user))
        }catch (e:Exception){
            emit(Result.failure(e))
        }
    }
}