package com.example.assesmentbhub.Api



import com.example.assesmentbhub.PostModel
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiInterface {
    @FormUrlEncoded // annotation used in POST type requests
    @GET("Posts")
    fun getPosts(@Header("Authorization") accessToken: String): Call<PostResponse>


}
