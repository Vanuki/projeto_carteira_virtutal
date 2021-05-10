package br.com.brq.projeto_carteira_virtutal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import br.com.brq.projeto_carteira_virtutal.Telas.SegundaTela

class MainActivity : AppCompatActivity() {

    lateinit var botao: Button
    lateinit var email: TextView
    lateinit var senha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()

        botao.setOnClickListener(){
            startActivity(Intent(this, SegundaTela::class.java))
        }

    }

    fun carregarElementos() {
        email = findViewById<TextView>(R.id.loguin)
        senha = findViewById<TextView>(R.id.senha)
        botao = findViewById<Button>(R.id.botao)
    }
}