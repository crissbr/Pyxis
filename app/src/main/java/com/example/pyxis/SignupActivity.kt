package com.example.pyxis

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        //Criando Shared Preference
        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)
        //Criando o editor
        val meuEditor = minhaPreferencia.edit()
        //Criando uma lista para o Spinner
     //   val listaSexo = arrayListOf("selecione o sexo", "Masculino", "Feminino")



        btncadastrar.setOnClickListener {
            val nome = edtName.text.toString().trim()
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtPass.text.toString().trim()
            val email = edtEmail.text.toString().trim().toLowerCase()

            if (nome.isEmpty() || usuario.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(
                    this@SignupActivity,
                    "Por favor preencha todos os campos",
                    Toast.LENGTH_LONG
                ).show()

            }  else {
                //Gravando as informações dentro do Shared Preferences
                meuEditor.putString("nome", nome).apply()
                meuEditor.putString("usuario", usuario).apply()
                meuEditor.putString("senha", senha).apply()
                meuEditor.putString("email", email).apply()


                //Criando um alert para o shared preference

                AlertDialog.Builder(this@SignupActivity)
                    .setTitle("Sucesso")
                    .setMessage("Usuario cadastrado com sucesso")
                    .setPositiveButton("Ok") { _, _ ->

                        onBackPressed()
                    }
                    .create()
                    .show()

            }

        }
    }
}
