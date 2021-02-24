package kz.jumysbar.intelteam.ui.tour

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kz.jumysbar.intelteam.ui.authorization.Member
import kz.jumysbar.intelteam.ui.usefulmaterial.UsefulMaterial
import java.util.*

@Entity(tableName = "tour_table")
data class Tour(
    @PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id")
val id: Int = 0,
    @ColumnInfo(name = "name")
val name: String,
    @ColumnInfo(name = "photo")
val photo: String, // need to add converter of photo
    @ColumnInfo(name = "description")
val description: String,
    @ColumnInfo(name = "date")
val date: Date,
    @ColumnInfo(name = "goal")
val goal: String,
    @ColumnInfo(name = "type")
val type: String,
    @ColumnInfo(name = "place")
val place: List<String>,
    @ColumnInfo(name = "location")
val location: List<String>,
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
val members: List<Member>,
    @ColumnInfo(name = "usefulMaterials")
val usefulMaterials: List<UsefulMaterial>,
    @ColumnInfo(name = "maxMembers")
val maxMembers: Int,
    @ColumnInfo(name = "tourStatus")
val status: String
)