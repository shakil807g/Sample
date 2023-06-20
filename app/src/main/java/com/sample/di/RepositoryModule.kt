package com.sample.di

import com.sample.data.repository.ViewerRepositoryImpl
import com.sample.domain.repository.ViewerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindRepository(repository: ViewerRepositoryImpl): ViewerRepository
}