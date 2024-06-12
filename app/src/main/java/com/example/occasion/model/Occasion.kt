package com.example.occasion.model

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName
import kotlinx.parcelize.Parcelize

@Parcelize
@IgnoreExtraProperties
data class Occasion(
    @get:PropertyName("id")
    @set:Exclude
    var id: String? = null,

    @get:PropertyName("description")
    @set:PropertyName("description")
    var description: String? = null,

    @get:PropertyName("status")
    @set:PropertyName("status")
    var status: Int = 0
) : Parcelable {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "description" to description,
            "status" to status
        )
    }
}
