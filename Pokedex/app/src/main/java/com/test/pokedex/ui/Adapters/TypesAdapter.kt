package com.test.pokedex.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.test.pokedex.R
import com.test.pokedex.utils.Intents

class TypesAdapter(
    private var context: Context,
    private var data: JsonArray
)
    : RecyclerView.Adapter<TypesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_detail, parent, false))
    }

    override fun getItemCount(): Int = data.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: JsonObject = data.get(position).asJsonObject

//        val url = item.get("url").asString
//        holder.detail.text = item.get("name").asString

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var detail: TextView = itemView.findViewById(R.id.pokemon_name)
    }
}