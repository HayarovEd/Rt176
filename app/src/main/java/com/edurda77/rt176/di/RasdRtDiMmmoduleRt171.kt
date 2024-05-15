package com.edurda77.rt176.di


import com.edurda77.rt176.data.repository.RemoteRepositoryrt176Impl
import com.edurda77.rt176.domain.repository.RemoteRepositoryrt176
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RasdRtDiMmmoduleRt171 {

   @Binds
    @Singleton
    abstract fun fghbindRepositoryRt171(remoteRepositoryrt176: RemoteRepositoryrt176Impl): RemoteRepositoryrt176


}