package com.test.pokedex.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.test.pokedex.R
import com.test.pokedex.interfaces.PokemonDetailInterface
import com.test.pokedex.presenters.PokemonDetailPresenter
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

class PokemonDetailActivity : AppCompatActivity(), PokemonDetailInterface {

    var url:String = ""

    lateinit var presenter: PokemonDetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        presenter = PokemonDetailPresenter(this, this)

        val bundle :Bundle ?=intent.extras
        url = bundle!!.getString("url").toString()

        onClick()
    }


    override fun onStart() {
        super.onStart()
        presenter.getValues(url)
    }

    private fun onClick(){
        btnBackDetail.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onSuccess(
        weight: String,
        height: String,
        id: String,
        name: String,
        imgUrl: String,
        types: JsonArray,
        moves: JsonArray,
        stats: JsonArray
    ) {
        renderView(weight,height,id,name,imgUrl,types,moves,stats)
    }


    private fun renderView(
        weight: String,
        height: String,
        id: String,
        name: String,
        imgUrl: String,
        types: JsonArray,
        moves: JsonArray,
        stats: JsonArray
    ) {
        txtNamePokemon.text = name
        txtNumberId.text = id
        txtWeight.text = "$weight kg"
        txtHeight.text = "$height m"
        txtType.text=getType(types)
        txtMoves.text = getMoves(moves)
        txtStats.text = getStats(stats)
        Glide.with(this)
             .load(imgUrl)
             .placeholder(R.drawable.ic_question)
             .error(R.drawable.ic_question)
             .into(imgPokemonDetail)
    }

    private fun getType(a: JsonArray): String{
        var type: String = ""

        for(i in a){
            var nType: JsonObject = i.asJsonObject.getAsJsonObject("type")
            type = type + nType.get("name").asString.capitalize() + " \n"
        }

        return type
    }

    private fun getStats(a: JsonArray): String{
        var stats: String = ""

        for(i in a){
            val stat = i.asJsonObject.get("base_stat").asString
            val nstat: JsonObject = i.asJsonObject.getAsJsonObject("stat")

            stats = stats + nstat.get("name").asString.capitalize() + ": " + stat + "\n"
        }

        return stats
    }

    private fun getMoves(a: JsonArray): String{
        var moveset: String = ""
        for(i in a){
            var nMove: JsonObject = i.asJsonObject.getAsJsonObject("move")
            moveset = moveset + nMove.get("name").asString.capitalize() + "\n"
        }
        return moveset
    }

}
