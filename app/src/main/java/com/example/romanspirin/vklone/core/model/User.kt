package com.example.romanspirin.vklone.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val access_token: String? = null,
    val isCurrent: Boolean = false
)