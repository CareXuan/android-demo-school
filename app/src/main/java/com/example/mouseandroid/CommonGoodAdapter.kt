package com.example.mouseandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CommonGoodAdapter(val context: Context, val GoodList: List<Good>) :
    RecyclerView.Adapter<CommonGoodAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val goodName: TextView = view.findViewById(R.id.common_good_name)
        val goodPic:ImageView = view.findViewById(R.id.common_good_resource)
        val userName:TextView = view.findViewById(R.id.common_good_user_name)
        val userAvatar:ImageView = view.findViewById(R.id.common_good_user_avatar)
        val goodPrice:TextView = view.findViewById(R.id.common_good_real_price)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommonGoodAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.common_good_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommonGoodAdapter.ViewHolder, position: Int) {
        val good = GoodList[position]
        holder.goodName.text = good.name
        holder.goodPrice.text = good.price
        good.resource.firstOrNull()?.run { Glide.with(context).load(this).into(holder.goodPic) }
        Glide.with(context).load(good.user.avatar).into(holder.userAvatar)
        holder.userName.text = good.user.nickname
    }

    override fun getItemCount() = GoodList.size

}