package br.com.brq.projeto_carteira_virtutal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var btnLogin:Button
    lateinit var editTextEmail: EditText
    lateinit var editTextSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()
        carregarEventos()
    }

    private fun carregarElementos(){
        btnLogin = findViewById(R.id.buttonEntrar)
        editTextEmail = findViewById(R.id.editTextEmailAddress)
        editTextSenha = findViewById(R.id.editTextPassword)
    }

    private fun carregarEventos() {
        btnLogin.setOnClickListener {

            val email = editTextEmail.text.toString()

            val senha = editTextSenha.text.toString()

            val usuario = User(email = email, senha = senha)

            if (usuario.validarEmail() && usuario.validarSenha()) {
                println("E-mail ou Senha válidos")
            } else {
                println("E-mail ou Senha inválidos")
            }

        }
    }
}