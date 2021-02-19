package kz.jumysbar.intelteam.ui.authorization

import androidx.room.*
import kz.jumysbar.intelteam.ui.tour.Tour

@Dao
interface MemberDao {
    @Query("SELECT * FROM member_table")
    fun getAll(): MutableList<Member>

    @Query("SELECT * FROM member_table WHERE id=:id ")
    fun loadbyId(id: String): Member

    @Query("SELECT COUNT(*) FROM member_table")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(member: MutableList<Member>)

    @Delete
    fun delete(tour: Tour)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMember(member: Member)
}