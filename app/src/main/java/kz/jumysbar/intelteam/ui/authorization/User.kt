package kz.jumysbar.intelteam.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var username: String? = "",
    var email: String? = "",
    var userPhotoURL: String? = ""

)