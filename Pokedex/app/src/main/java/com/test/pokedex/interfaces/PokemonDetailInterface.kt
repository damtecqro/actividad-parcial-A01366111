package com.test.pokedex.interfaces

import com.google.gson.JsonArray

interface PokemonDetailInterface {
    fun onSuccess(
        weight: String,
        height: String,
        id: String,
        name: String,
        imgUrl: String,
        types: JsonArray,
        moves: JsonArray,
        stats: JsonArray
    )
}