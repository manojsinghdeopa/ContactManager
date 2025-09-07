package com.msd.contactmanager.data.model

// Create a data class for Contact entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val phoneNumber: String,
    val email: String
)
