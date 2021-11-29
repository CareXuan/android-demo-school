package com.example.mouseandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class HomepageGoodAdapter(val context: Context, val GoodList: List<Good>) :
    RecyclerView.Adapter<HomepageGoodAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val goodName: TextView = view.findViewById(R.id.homepage_good_name)
        val goodCreateAt: TextView = view.findViewById(R.id.homepage_good_create_time)
        val goodPic: ImageView = view.findViewById(R.id.homepage_good_picture)
        val goodPrice: TextView = view.findViewById(R.id.good_price)
        val userAvatar: ImageView = view.findViewById(R.id.good_user_avatar)
        val username: TextView = view.findViewById(R.id.good_user_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.good_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val good = GoodList[position]
        holder.goodName.text = good.name
        holder.goodCreateAt.text = good.create_time
        holder.goodPrice.text = good.price
        good.resource.firstOrNull()?.run { Glide.with(context).load(this).into(holder.goodPic) }
        Glide.with(context).load(good.user.avatar).into(holder.userAvatar)
        holder.username.text = good.user.nickname
    }

    override fun getItemCount() = GoodList.size
}