package com.plcoding.shared.di

import com.plcoding.shared.data.ds.ExercisesDao
import com.plcoding.shared.data.ds.ExercisesDatabase
import com.plcoding.shared.data.ds.ExercisesDbCallback
import com.plcoding.shared.data.repository.api.TrainingDaysRepository
import com.plcoding.shared.data.repository.implementation.TrainingDaysRepositoryImpl
import com.plcoding.shared.presentation.viewmodel.ExercisesViewModel
import com.plcoding.shared.presentation.viewmodel.TrainingDaysViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    // Data Layer
    singleOf(::ExercisesDbCallback)
    single<ExercisesDao> { get<ExercisesDatabase>().exercisesDao() }
    singleOf(::TrainingDaysRepositoryImpl) bind TrainingDaysRepository::class

    // Domain Layer

    // Presentation Layer
    singleOf(::TrainingDaysViewModel)
    factoryOf(::ExercisesViewModel)
}

expect val platformModule: Module
