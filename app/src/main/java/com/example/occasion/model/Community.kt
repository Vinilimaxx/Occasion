package com.example.occasion.model

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName
import kotlinx.parcelize.Parcelize

@Parcelize
@IgnoreExtraProperties
data class Community(
    @get:PropertyName("id")
    @set:Exclude
    var id: String? = null,

    @get:PropertyName("description")
    @set:PropertyName("description")
    var description: String? = null,

    @get:PropertyName("name")
    @set:PropertyName("name")
    var name: String? = null
) : Parcelable {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "description" to description,
            "name" to name
        )
    }
}