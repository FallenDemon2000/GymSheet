package com.plcoding.shared.di

import com.plcoding.shared.data.ds.api.TrainingDaysDataSource
import com.plcoding.shared.data.ds.implementation.TrainingDaysDataSourceImpl
import com.plcoding.shared.data.repository.api.TrainingDaysRepository
import com.plcoding.shared.data.repository.implementation.TrainingDaysRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    // Data Layer
    singleOf(::TrainingDaysDataSourceImpl) bind TrainingDaysDataSource::class
    singleOf(::TrainingDaysRepositoryImpl) bind TrainingDaysRepository::class

    // Domain Layer

    // Presentation Layer

}
