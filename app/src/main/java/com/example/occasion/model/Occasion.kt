package com.example.occasion.model

import android.os.Parcelable
import com.example.occasion.helper.FirebaseHelper
import com.google.firebase.ktx.Firebase
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Occasion (
    var id: String = "",
    var description: String = "",
    var status: Int = 0
): Parcelable{
    init {
        this.id = FirebaseHelper.getDatabse().push().key ?:""
    }
}