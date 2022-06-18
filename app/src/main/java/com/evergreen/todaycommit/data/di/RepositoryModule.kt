package com.evergreen.todaycommit.data.di

import com.evergreen.todaycommit.data.remote.repository.GithubRepositoryImpl
import com.evergreen.todaycommit.domain.repository.GithubRepository
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
    abstract fun bindGithubUserRepository(
        repository: GithubRepositoryImpl
    ): GithubRepository
}