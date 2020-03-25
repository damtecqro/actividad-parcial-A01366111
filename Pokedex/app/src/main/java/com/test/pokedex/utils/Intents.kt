package com.test.pokedex.utils

import android.content.Context
import android.content.Intent
import com.test.pokedex.ui.Activities.ListActivity
import com.test.pokedex.ui.Activities.PokemonDetailActivity

object Intents {
    fun goToHome(mC: Context){
        val intent = Intent(mC, ListActivity::class.java)
        mC.startActivity(intent)
    }

    fun goToDetails(mC: Context, url: String){
        val intent = Intent(mC, PokemonDetailActivity::class.java)
        intent.putExtra("url",url)
        mC.startActivity(intent )
    }
}