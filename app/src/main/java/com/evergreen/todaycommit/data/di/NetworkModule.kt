package com.evergreen.todaycommit.data.di

import com.evergreen.todaycommit.data.remote.api.SkylineApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideSkylineService(retrofit: Retrofit): SkylineApi =
        retrofit.create(SkylineApi::class.java)

    @Provides
    @Singleton
    fun provideSkylineRetrofit(
        converterFactory: JacksonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://skyline.github.com/")
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    fun provideConverterFactory(): JacksonConverterFactory = JacksonConverterFactory.create()

    @Provides
    fun provideOkhttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}