package com.example.assesmentbhub.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesmentbhub.models.Posts

class PostsAdapter(var postsList: List<Posts>, var postsItemClickListener: PostsItemClickListener) :
    RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_name_item, parent, false)
        return PostsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.rowView.tvName.text =postsList[position].title {
            postsItemClickListener.onItemClick(postsList[position])
        }.toString()
    }

    class PostsViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}

private operator fun String.invoke(any: Any): Any {
    TODO("Not yet implemented")
}




