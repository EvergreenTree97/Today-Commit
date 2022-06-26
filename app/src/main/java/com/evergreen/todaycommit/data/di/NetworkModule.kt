package com.evergreen.todaycommit.data.di

import com.evergreen.todaycommit.data.remote.api.GithubApi
import com.squareup.leakcanary.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
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
    fun provideGithubService(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(
        converterFactory: JacksonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://skyline.github.com")
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
/*
    @Provides
    fun provideOkhttpInterceptor() =
        Interceptor{ chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            val authorization = BuildConfig.GIT_SHA
            requestBuilder.addHeader("Authorization", authorization)
            val request = requestBuilder.build()
            chain.proceed(request)
        }

 */
}