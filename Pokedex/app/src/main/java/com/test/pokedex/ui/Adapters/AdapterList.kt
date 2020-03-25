package com.test.pokedex.ui.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion
import com.test.pokedex.R
import com.test.pokedex.utils.Intents

class AdapterList(
    private var context: Context,
    private var data: JsonArray)
    :RecyclerView.Adapter<AdapterList.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list,parent,false))
    }

    override fun getItemCount(): Int = data.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item:JsonObject = data.get(position).asJsonObject

        val url = item.get("url").asString
        holder.namePokemon.text = item.get("name").asString

        holder.layout.setOnClickListener {
            Intents.goToDetails(context,url)
        }
        getValues(item,context,holder)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var imagePokemon: ImageView = itemView.findViewById(R.id.pokemon_image)
        var namePokemon: TextView   = itemView.findViewById(R.id.pokemon_name)
        var layout:ConstraintLayout = itemView.findViewById(R.id.layout_item)
    }

    private fun getValues(item:JsonObject, context: Context, holder: ViewHolder){
        Ion.with(context)
            .load(item.get("url").asString)
            .asJsonObject()
            .done { e, result ->
                if(e == null){
                    if(!result.get("sprites").isJsonNull){
                        if(result.get("sprites").asJsonObject.get("front_default") != null){
//                            Log.i("Salida", result.get("sprites").asJsonObject.get("front_default").asString)
                            Glide
                                .with(context)
                                .load(result.get("sprites").asJsonObject.get("front_default").asString)
                                .placeholder(R.drawable.pokemon_logo_min)
                                .error(R.drawable.ic_question)
                                .into(holder.imagePokemon)
                        }else{
                            holder.imagePokemon.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_question))
                        }
                    }else{
                        holder.imagePokemon.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_question))
                    }
                }
            }
    }

}