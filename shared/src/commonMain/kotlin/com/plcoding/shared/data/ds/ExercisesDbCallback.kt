package com.plcoding.shared.data.ds

import androidx.room.RoomDatabase
import androidx.sqlite.SQLiteConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class ExercisesDbCallback() : RoomDatabase.Callback(), KoinComponent {
    override fun onCreate(connection: SQLiteConnection) {
        super.onCreate(connection)
        val dao = get<ExercisesDao>()
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertDays(*StaticData.staticTrainingDays)
            dao.insertExercises(*StaticData.staticExercises)
        }
    }
}
