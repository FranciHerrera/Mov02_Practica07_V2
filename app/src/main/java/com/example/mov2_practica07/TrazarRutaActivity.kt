package com.example.mov2_practica07

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TrazarRutaActivity : AppCompatActivity() {

    private lateinit var etOrigen: EditText
    private lateinit var etDestino: EditText
    private lateinit var btnMostrarRuta: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trazar_ruta)

        etOrigen = findViewById(R.id.etOrigen)
        etDestino = findViewById(R.id.etDestino)
        btnMostrarRuta = findViewById(R.id.btnMostrarRuta)

        btnMostrarRuta.setOnClickListener {
            val origen = etOrigen.text.toString()
            val destino = etDestino.text.toString()

            if (origen.isEmpty() || destino.isEmpty()) {
                Toast.makeText(
                    this,
                    "Por favor, ingrese ambos campos",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                mostrarRutaEnGoogleMaps(origen, destino)
            }
        }
    }

    private fun mostrarRutaEnGoogleMaps(origen: String, destino: String) {
        val uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=$origen&destination=$destino&travelmode=driving")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Google Maps no está instalado", Toast.LENGTH_SHORT).show()
        }
    }
}