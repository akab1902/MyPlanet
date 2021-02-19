package kz.jumysbar.intelteam.ui.tour

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tour_table")
data class Tour(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "dates")
    val dates: String,
    @ColumnInfo(name = "goal")
    val goal: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "place")
    val place: String, // need change to List
    @ColumnInfo(name = "location")
    val location: String, // need change to List
    @ColumnInfo(name = "cost")
    val cost: Float,
    @ColumnInfo(name = "length")
    val length: Int,
    @ColumnInfo(name = "notes")
    val notes: String,
    @ColumnInfo(name = "visa")
    val visa: Boolean,
    @ColumnInfo(name = "difficulty")
    val difficulty: String,
    @ColumnInfo(name = "members")
    val members: String, // need to change to List<Member>
    @ColumnInfo(name = "usefulMaterials")
    val usefulMaterials: String, // need to change List<UsefulMaterial>
    @ColumnInfo(name = "maxMembers")
    val maxMembers: Int
)