package kz.jumysbar.intelteam.ui.usefulmaterial

import androidx.room.*
import kz.jumysbar.intelteam.ui.authorization.Member

@Dao
interface UsefulMaterialDao {
    @Query("SELECT * FROM usefulMaterial_table")
    fun getAll(): MutableList<UsefulMaterial>

    @Query("SELECT * FROM usefulMaterial_table WHERE id=:id ")
    fun loadbyId(id: String): UsefulMaterial

    @Query("SELECT COUNT(*) FROM usefulMaterial_table")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(material: MutableList<UsefulMaterial>)

    @Delete
    fun delete(material: UsefulMaterial)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsefulMaterial(material: UsefulMaterial)
}