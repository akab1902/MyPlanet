package kz.jumysbar.intelteam.ui.authorization

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import kz.jumysbar.intelteam.ui.tour.Tour

@Dao
interface MemberDao {
    @Query("SELECT * FROM member_table")
    fun getAll(): List<Member>

    @Query("SELECT * FROM member_table WHERE id=:id ")
    fun loadbyId(id: String): Member

    @Query("SELECT COUNT(*) FROM member_table")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(member: List<Member>)

    @Delete
    fun delete(tour: Tour)

    @Query("DELETE FROM member_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMember(member: Member)
}