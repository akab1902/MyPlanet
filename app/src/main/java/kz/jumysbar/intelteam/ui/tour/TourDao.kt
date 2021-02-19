package kz.jumysbar.intelteam.ui.tour

import androidx.room.*

@Dao
interface TourDao {
    @Query("SELECT * FROM tour_table")
    fun getAll(): MutableList<Tour>

    @Query("SELECT * FROM tour_table WHERE id=:id ")
    fun loadbyId(id: String): Tour

    @Query("SELECT COUNT(*) FROM tour_table")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tour: MutableList<Tour>)

    @Delete
    fun delete(tour: Tour)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTour(tour: Tour)
}