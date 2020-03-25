package com.test.pokedex.ui.Activities

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Surface
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion
import com.test.pokedex.R
import com.test.pokedex.ui.Adapters.AdapterList
import kotlinx.android.synthetic.main.activity_list.*
import org.json.JSONArray
import org.json.JSONObject


class ListActivity : AppCompatActivity() {

    private lateinit var data: JsonArray

    val managerVertical = GridLayoutManager(this@ListActivity, 2)
    val managerHorizontal = GridLayoutManager(this@ListActivity, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initializeData(managerVertical)
    }

    private fun initializeData(manager: GridLayoutManager) {
        Ion.with(this)
            .load("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=964")
            .asJsonObject()
            .done { e, result ->
                if(e == null){
                    Log.i("DebugQuerys", result.getAsJsonArray("results").toString())
                    data = result.getAsJsonArray("results")
                    initializeList(manager)
                }
            }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            initializeData(managerHorizontal)
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            initializeData(managerVertical)
        }
    }

    private fun initializeList(manager: GridLayoutManager) {
        recycler_view_list.layoutManager = manager
        recycler_view_list.adapter = AdapterList(this,data)
    }

}
