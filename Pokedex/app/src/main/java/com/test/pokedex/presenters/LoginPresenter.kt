package com.test.pokedex.presenters

import android.content.Context
import android.view.View
import com.test.pokedex.interfaces.LoginInterface

class LoginPresenter(val context: Context,val mListener:LoginInterface){

    fun validateFields(
        name: String,
        password: String,
        it: View
    ){
        if(name.isEmpty()){
            mListener.onError(it,"Por favor un ingresa un usuario")
            return
        }
        if(password.isEmpty()){
            mListener.onError(it, "Por favor ingresa una contraseña")
            return
        }

        mListener.onSuccess(    )
    }
}