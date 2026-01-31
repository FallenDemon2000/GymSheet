package com.plcoding.shared.di

import android.content.Context
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.plcoding.shared.data.ds.ExercisesDatabase
import com.plcoding.shared.ktx.getDatabaseBuilder
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

actual val platformModule = module {
    single<ExercisesDatabase> {
        getDatabaseBuilder(get<Context>())
            .addMigrations()
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}
