package com.example.mytherapy.di

import android.content.Context
import androidx.room.Room
import com.example.mytherapy.data.local.AppDatabase
import com.example.mytherapy.data.local.MedicationDao
import com.example.mytherapy.data.repository.MedicationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "mytherapy_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMedicationDao(appDatabase: AppDatabase): MedicationDao {
        return appDatabase.medicationDao()
    }

    @Provides
    @Singleton
    fun provideMedicationRepository(medicationDao: MedicationDao): MedicationRepository {
        return MedicationRepository(medicationDao)
    }
}
