package kz.jumysbar.intelteam.ui.usefulmaterial

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.OnConflictStrategy
@Dao
interface UsefulMaterialDao {
    @Query("SELECT * FROM usefulMaterial_table")
    fun getAll(): List<UsefulMaterial>

    @Query("SELECT * FROM usefulMaterial_table WHERE id=:id ")
    fun loadbyId(id: String): UsefulMaterial

    @Query("SELECT COUNT(*) FROM usefulMaterial_table")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(material: List<UsefulMaterial>)

    @Delete
    fun delete(material: UsefulMaterial)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsefulMaterial(material: UsefulMaterial)
}