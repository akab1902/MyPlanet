package kz.jumysbar.intelteam.ui.authorization

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "member_table")
data class Member(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "dateOfBirth")
    val dateOfBirth: String, // need to change to Date and add converter
    @ColumnInfo(name = "sex")
    val sex: String,
    @ColumnInfo(name = "level")
    val level: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "dateOfAdd")
    val dateOfAdd: String, // need to change to Date and add converter
    @ColumnInfo(name = "dateOfDel")
    val dateOfDel: String,
    @ColumnInfo(name = "placeWork")
    val placeWork: String,
    @ColumnInfo(name = "hobbies")
    val hobbies: String,
    @ColumnInfo(name = "descAboutYourself")
    val descAboutYourself: String,
    @ColumnInfo(name = "visa")
    val visa: String, // need change to List
    @ColumnInfo(name = "score")
    val score: Int
)