package com.test.pokedex.presenters

import android.content.Context
import com.koushikdutta.ion.Ion
import com.test.pokedex.interfaces.PokemonDetailInterface

class PokemonDetailPresenter(val context: Context,val mListener:PokemonDetailInterface) {

    fun getValues(url:String){
        Ion.with(context)
            .load(url)
            .asJsonObject()
            .done { e, result ->
                if(e == null){
                    val imgUrl = result.get("sprites").asJsonObject.get("front_default").asString
                    val weight = result.get("weight").toString()
                    val height = result.get("height").toString()
                    val id = result.get("id").toString()
                    val name = result.get("name").toString()
                    val stats = result.get("stats").asJsonArray
                    val types = result.get("types").asJsonArray
                    val moves = result.get("moves").asJsonArray
                    mListener.onSuccess(weight, height,id,name,imgUrl,types,moves,stats)
                }
            }
    }

}