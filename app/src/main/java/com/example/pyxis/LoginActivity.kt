package com.example.pyxis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnEntrar.setOnClickListener {

            val usuario = edtUsuario.text.toString().trim()
            val senha = edtPassword.text.toString().trim()

            val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

            val pass = minhaPreferencia.getString("senha", "Não encontrado.")
            val user = minhaPreferencia.getString("usuario", "Não encontrado.")

            if (usuario.isEmpty()){
                Toast.makeText(this@LoginActivity, "Usuário vazio.", Toast.LENGTH_LONG).show()
            } else if (senha.isEmpty()){
                Toast.makeText(this@LoginActivity, "Senha vazia.", Toast.LENGTH_LONG).show()
            } else if (usuario == user && senha == pass){
                startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
            } else {
                AlertDialog.Builder(this@LoginActivity)
                    .setTitle("Erro de Autenticação")
                    .setMessage("Usuário ou senha incorretos. Tente novamente.")
                    .setPositiveButton("OK"){ _,_ ->
                    }
                    .create()
                    .show()
            }
        }
    }
}
