package kz.jumysbar.intelteam.ui.usefulmaterial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usefulMaterial_table")
data class UsefulMaterial(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "photo")
    val photo: String, // need to add converter of photo
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "cost")
    val cost: Float,
    @ColumnInfo(name = "notes")
    val notes: String
)