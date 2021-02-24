package kz.jumysbar.intelteam.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import kz.jumysbar.intelteam.ui.authorization.Member
import kz.jumysbar.intelteam.ui.usefulmaterial.UsefulMaterial
import java.util.*

class Converters {
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun membersToJson(value: List<Member>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToMembers(value: String) = Gson().fromJson(value, Array<Member>::class.java).toList()

    @TypeConverter
    fun materialsToJson(value: List<UsefulMaterial>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToMaterials(value: String) = Gson().fromJson(value, Array<UsefulMaterial>::class.java).toList()

    @TypeConverter
    fun longToDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
    }

    @TypeConverter
    fun dateToLong(date: Date?): Long? {
        return date?.time
    }
}