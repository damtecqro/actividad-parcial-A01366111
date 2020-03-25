package com.test.pokedex.ui.Adapters

import android.content.Context
import android.util.Log
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

class MovesAdapter(
    private var context: Context,
    private var data: JsonArray
)
    : RecyclerView.Adapter<MovesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_detail, parent, false))
    }

    override fun getItemCount(): Int = data.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: JsonObject = data.get(position).asJsonObject

        val name = item.get("slot").toString()
        val type = item.get("type").asJsonObject.get("name").toString()

        Log.d("DebugQuerys",name + type)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var detail: TextView = itemView.findViewById(R.id.pokemon_name)
    }

}