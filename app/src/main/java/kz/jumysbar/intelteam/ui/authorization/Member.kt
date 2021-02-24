package kz.jumysbar.intelteam.ui.authorization

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "member_table")
data class Member(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "dateOfBirth")
    val dateOfBirth: Date, // need to check correctness of converter
    @ColumnInfo(name = "sex")
    val sex: String,
    @ColumnInfo(name = "level")
    val level: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "photo")
    val photo: String, // need to add converter of photo
    @ColumnInfo(name = "dateOfAdd")
    val dateOfAdd: Date,
    @ColumnInfo(name = "dateOfDel")
    val dateOfDel: Date,
    @ColumnInfo(name = "placeWork")
    val placeWork: String,
    @ColumnInfo(name = "hobbies")
    val hobbies: String,
    @ColumnInfo(name = "descAboutYourself")
    val descAboutYourself: String,
    @ColumnInfo(name = "visa")
    val visa: List<String>,
    @ColumnInfo(name = "score")
    val score: Int
)