package kz.jumysbar.intelteam.ui.tour
import androidx.room.Dao
import androidx.room.Query
import androidx.room.OnConflictStrategy
import androidx.room.Delete
import androidx.room.Insert
import java.util.*

@Dao
interface TourDao {
    @Query("SELECT * FROM tour_table")
    fun getAll(): List<Tour>

    @Query("SELECT * FROM tour_table WHERE id=:id ")
    fun loadbyId(id: String): Tour

    @Query("SELECT COUNT(*) FROM tour_table")
    fun getCount(): Int

    @Query("SELECT date FROM tour_table WHERE name  = :name")
    fun getDatebyTour(name: String): Date

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tour: List<Tour>)

    @Delete
    fun delete(tour: Tour)

    @Query("DELETE FROM tour_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTour(tour: Tour)
}