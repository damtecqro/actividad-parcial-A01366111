package com.test.pokedex.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.test.pokedex.R
import com.test.pokedex.interfaces.LoginInterface
import com.test.pokedex.presenters.LoginPresenter
import com.test.pokedex.utils.Intents
import com.test.pokedex.utils.Msn
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginInterface {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this,this)
        onClick()
    }

    private fun onClick(){
        btnLogIn.setOnClickListener {
            presenter.validateFields(
                txtUserName.text.toString(),
                txtPassword.text.toString(),
                it)
        }
    }

    override fun onSuccess() {
        Intents.goToHome(this)
        finish()
    }

    override fun onError(it: View, s: String) {
        Msn.snack(it,s)
    }
}

