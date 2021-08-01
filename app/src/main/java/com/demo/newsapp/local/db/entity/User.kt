package com.demo.newsapp.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: Int,
    val admin: Boolean,
    val nickname: String,
    val email: String,
    val icon: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    val username: String
)