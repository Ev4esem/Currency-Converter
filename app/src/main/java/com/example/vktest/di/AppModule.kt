package com.example.vktest.di

import com.example.vktest.data.remove_source.CurrencyApi
import com.example.vktest.data.remove_source.CurrencyRepositoryImpl
import com.example.vktest.domain.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun currencyRepository(currencyRepositoryImpl: CurrencyRepositoryImpl): CurrencyRepository

    companion object {
        const val BASE_URL = "https://app.currencyapi.com/"
        const val API_KEY = "cur_live_riCHmMpBy9P9WtmWoPlJs6wzLuSkgbxrYOwY0dvI"

        @Provides
        private fun provideRetrofit() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        @Provides
        private fun provideCurrencyApi(retrofit: Retrofit) = retrofit.create(CurrencyApi::class.java)

    }

}