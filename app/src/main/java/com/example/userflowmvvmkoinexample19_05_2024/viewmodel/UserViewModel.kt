package com.example.userflowmvvmkoinexample19_05_2024.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userflowmvvmkoinexample19_05_2024.model.UserData
import com.example.userflowmvvmkoinexample19_05_2024.repository.UserDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userDataRepository: UserDataRepository):ViewModel(){

     var userFlow = MutableStateFlow<List<UserData>>(emptyList())

  init {
      viewModelScope.launch {
          userDataRepository.getUserListData().collect{
              userFlow.value = it as List<UserData>
          }
      }
  }


}