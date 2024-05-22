package com.lo.mpm.matchs.oolimob.mobile.sports.omms.di


import com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.repository.RemoteRepositoryrt176Impl
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.domain.repository.RemoteRepositoryrt176
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RasdRtDiMmmoduleRt176 {

   @Binds
    @Singleton
    abstract fun fghbindRepositoryRt176(remoteRepositoryrt176: RemoteRepositoryrt176Impl): RemoteRepositoryrt176


}