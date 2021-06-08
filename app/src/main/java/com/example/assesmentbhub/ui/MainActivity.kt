package com.example.assesmentbhub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.assesmentbhub.Api.ApiClient
import com.example.assesmentbhub.Api.ApiInterface
import com.example.assesmentbhub.R
import com.example.assesmentbhub.models.PostResponse
import com.example.assesmentbhub.models.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchposts()
    }
    fun fetchposts() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val postsCall = apiClient.getPosts("Bearer " + accessToken)
        postsCall.enqueue (object : Callback<PostResponse> {
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if (response.isSuccessful) {
                    var postList = response.body()?.post as List<Posts>
                    Thread {
                        postList.forEach { posts ->
                            val database = null
                            database.run {
                                PostsDao().insertPosts(posts)
                            }
                        }
                    }.start()

                    displayPosts(postList)
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })}

    private fun displayPosts(postList: List<Posts>) {
        TODO("Not yet implemented")
    }
}

private fun Any.insertPosts(posts: Posts) {
    TODO("Not yet implemented")
}


private fun Nothing?.PostsDao(): Any {
    TODO("Not yet implemented")
}

}