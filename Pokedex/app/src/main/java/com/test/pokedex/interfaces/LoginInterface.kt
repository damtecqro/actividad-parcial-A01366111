package com.test.pokedex.interfaces

import android.view.View

interface LoginInterface {
    fun onSuccess()
    fun onError(it: View, s: String)
}