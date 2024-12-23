package com.example.userflowmvvmkoinexample19_05_2024.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userflowmvvmkoinexample19_05_2024.R
import com.example.userflowmvvmkoinexample19_05_2024.model.UserData


class UserItemsAdapter(
    private val userData: ArrayList<UserData>
) : RecyclerView.Adapter<UserItemsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id = itemView.findViewById<TextView>(R.id.textViewid)
        var name = itemView.findViewById<TextView>(R.id.textViewname)
        var userName = itemView.findViewById<TextView>(R.id.textViewusername)

        fun bind(userData: UserData) {
           id.text = userData.id
           name.text = userData.id
           userName.text = userData.username
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = userData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int){
        holder.bind(userData[position])
    }

    fun addData(list: List<UserData>) {
        userData.addAll(list)
    }

}