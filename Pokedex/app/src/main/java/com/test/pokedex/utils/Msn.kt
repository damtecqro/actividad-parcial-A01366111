package com.test.pokedex.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object Msn {
    fun snack(view: View, msn:String ){
        Snackbar.make(view, msn, Snackbar.LENGTH_LONG).show()
    }

    fun toast(context: Context, msn: String){
        Toast.makeText(context,msn, Toast.LENGTH_SHORT).show()
    }
}