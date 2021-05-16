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

            if (usuario.validarEmail() && usuario.validarSenha()) {
                startActivity(Intent(this, SegundaTela::class.java))
            } else {
                email.error = "E-MAIL OU SENHA INCORRETOS"
                senha.error = "E-MAIL OU SENHA INCORRETOS"
            }
        }
    }


    fun carregarElementos() {
        email = findViewById(R.id.email)
        senha = findViewById(R.id.senha)
        botaoEntrar = findViewById(R.id.botao)
    }

}