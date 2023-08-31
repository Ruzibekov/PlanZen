package uz.ruzibekov.planzen.ui.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.planzen.ui.data.room.dao.BlockDao
import uz.ruzibekov.planzen.ui.data.room.dao.TagDao
import uz.ruzibekov.planzen.ui.data.room.database.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "local-database").build()

    @Provides
    fun provideBlockDao(appDatabase: AppDatabase): BlockDao = appDatabase.blockDao()

    @Provides
    fun provideTagDao(appDatabase: AppDatabase): TagDao = appDatabase.tagDao()
}