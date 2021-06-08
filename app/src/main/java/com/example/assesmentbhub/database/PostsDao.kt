package com.example.assesmentbhub.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assesmentbhub.models.Posts


interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserPosts(posts: Posts)
    @Query("SELECT * FROM post")
    fun getAllPosts(): List<Posts>


}