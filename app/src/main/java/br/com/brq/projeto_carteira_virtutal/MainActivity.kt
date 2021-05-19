package br.com.brq.projeto_carteira_virtutal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projeto_carteira_virtutal.Model.Gastos
import br.com.brq.projeto_carteira_virtutal.Model.User
import br.com.brq.projeto_carteira_virtutal.Telas.SegundaTela
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var botaoEntrar: Button
    lateinit var email: TextView
    lateinit var senha: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()


        botaoEntrar.setOnClickListener() {
            val usuario = User(email = email.text.toString(), senha = senha.text.toString())
            val validaEmail = usuario.validarEmail()
            val validaSenha = usuario.validarSenha()

            if (validaEmail && validaSenha) {
                startActivity(Intent(this, SegundaTela::class.java))
            } else {
                if(!validaEmail){
                    email.error = "E-MAIL INCORRETO"
                }
                if(!validaSenha){
                    senha.error = "SENHA INCORRETA"
                }
            }
        }
    }


    fun carregarElementos() {
        email = findViewById(R.id.email)
        senha = findViewById(R.id.senha)
        botaoEntrar = findViewById(R.id.botao)
    }

}