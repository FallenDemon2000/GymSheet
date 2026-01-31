package com.plcoding.shared.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.plcoding.shared.data.ds.ExercisesDatabase
import com.plcoding.shared.ktx.getDatabaseBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

actual val platformModule = module {
    single<ExercisesDatabase> {
        getDatabaseBuilder()
            .addMigrations()
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}
