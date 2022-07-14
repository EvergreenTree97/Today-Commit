package com.evergreen.todaycommit.data.di

import com.evergreen.todaycommit.data.repository.SkylineRepositoryImpl
import com.evergreen.todaycommit.domain.repository.SkylineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSkylineRepository(
        repository: SkylineRepositoryImpl
    ): SkylineRepository
}