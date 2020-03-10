package com.example.pyxis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)
        val nome = minhaPreferencia.getString("nome", "erro")
        val usuario = minhaPreferencia.getString("usuario", "erro")
        val email = minhaPreferencia.getString("email", "erro")

        textNomeUsuario.text = "@$usuario"
        textNome.text = "$usuario"
        textEmail.text = "$email"
        textChamado.text = "$nome"

        btnSair.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, MainActivity::class.java))
            finishAffinity()
        }

        btnSearchPerfil.setOnClickListener{
            startActivity(Intent(this@ProfileActivity, WebActivity::class.java))
        }
    }
}
