package kz.jumysbar.intelteam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.jumysbar.intelteam.ui.authorization.Member
import kz.jumysbar.intelteam.ui.authorization.MemberDao
import kz.jumysbar.intelteam.ui.tour.Tour
import kz.jumysbar.intelteam.ui.tour.TourDao
import kz.jumysbar.intelteam.ui.usefulmaterial.UsefulMaterial
import kz.jumysbar.intelteam.ui.usefulmaterial.UsefulMaterialDao

@Database(entities = [Tour::class, Member::class, UsefulMaterial::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {

    abstract fun tourDao(): TourDao
    abstract fun memberDao(): MemberDao
    abstract fun usefulMaterialDao(): UsefulMaterialDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MainDatabase =
            Room.databaseBuilder(
                context,
                MainDatabase::class.java, "main-database"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}