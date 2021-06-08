package com.example.assesmentbhub.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post")
data class Posts(
    @SerializedName("post_id") var title: String

)