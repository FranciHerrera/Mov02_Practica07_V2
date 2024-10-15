package com.example.mov2_practica07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var boton: Button
    private lateinit var boton1: Button
    private lateinit var boton2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //boton = findViewById(R.id.activity_main_maps)
        boton1 = findViewById(R.id.button1)
        boton2 = findViewById(R.id.button2)

        //boton.setOnClickListener { onClickMaps() }
        boton1.setOnClickListener { onClickTrazarRuta() }
        boton2.setOnClickListener { onClickTrazarRutaPolilinea() }
    }

    /*
    private fun onClickMaps() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }
    */

    private fun onClickTrazarRuta() {
        val intent = Intent(this, TrazarRutaActivity::class.java)
        startActivity(intent)
    }

    private fun onClickTrazarRutaPolilinea() {
        val intent = Intent(this, TrazarRutaPolilineaActivity::class.java)
        startActivity(intent)
    }
}