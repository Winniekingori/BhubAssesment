package com.example.assesmentbhub.models

import com.example.assesmentbhub.models.Posts
import com.google.gson.annotations.SerializedName

data class PostResponse (
    @SerializedName("post") var post: List<Posts>
)
