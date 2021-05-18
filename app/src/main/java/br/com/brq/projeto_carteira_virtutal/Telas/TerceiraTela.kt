package br.com.brq.projeto_carteira_virtutal.Telas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import br.com.brq.projeto_carteira_virtutal.R

lateinit var entradaValor: EditText
lateinit var saidaValor: TextView
lateinit var botao: ImageButton

open class TerceiraTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_tela)


        carregarElementos()
        carregarEventos()



    }


    fun carregarElementos() {
        entradaValor = findViewById(R.id.entrada_valor)
        saidaValor = findViewById(R.id.saida_valor)
        botao = findViewById(R.id.botao_entrada)
    }

    fun carregarEventos() {
        val activity = parent as SegundaTela
        botao.setOnClickListener(){
        saidaValor = activity.somaSaldo
        }
    }
}