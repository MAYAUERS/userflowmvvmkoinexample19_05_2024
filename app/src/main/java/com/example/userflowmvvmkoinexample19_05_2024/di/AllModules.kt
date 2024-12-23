package com.example.userflowmvvmkoinexample19_05_2024.di

import com.example.userflowmvvmkoinexample19_05_2024.network.ApiService
import com.example.userflowmvvmkoinexample19_05_2024.repository.UserDataRepository
import com.example.userflowmvvmkoinexample19_05_2024.viewmodel.UserViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var networkModule = module {

    single { provideRetrofit(okHttpClient = get()) }
    factory { provideOkHttpClient(httpLoggingInterceptor = get()) }
    factory { HttpLoggingInterceptor() }
    factory { provideService(retrofit = get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor
            .setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}
fun provideService(retrofit: Retrofit):ApiService{
    return retrofit.create(ApiService::class.java)
}

var appModule = module {

    single { UserDataRepository(apiService = get()) }
    viewModel { UserViewModel(userDataRepository = get()) }
}