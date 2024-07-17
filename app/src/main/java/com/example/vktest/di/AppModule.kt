package com.example.vktest.di

import com.example.vktest.data.remove_source.CurrencyApi
import com.example.vktest.data.remove_source.CurrencyRepositoryImpl
import com.example.vktest.domain.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun currencyRepository(currencyRepositoryImpl: CurrencyRepositoryImpl): CurrencyRepository

}