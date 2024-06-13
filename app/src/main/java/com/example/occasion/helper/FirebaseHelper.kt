//package com.example.occasion.helper
//
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.auth.FirebaseAuth
//import java.lang.Error
//
//class FirebaseHelper {
//
//    companion object{
//
//        fun getDatabse() = FirebaseDatabase.getInstance().reference
//
//        fun getAuth() = FirebaseAuth.getInstance()
//
//        fun getIdUser() = getAuth().uid
//
//        fun isAutenticated() = getAuth().currentUser != null
//
//        fun validError(error: String): int{
//            return when{
//                error.contains("")-> {
//
//                }else -> {
//
//                }
//            }
//        }
//    }
//
//}