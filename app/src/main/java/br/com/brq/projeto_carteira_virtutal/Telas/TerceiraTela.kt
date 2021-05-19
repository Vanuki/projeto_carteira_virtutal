package br.com.brq.projeto_carteira_virtutal.Telas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import br.com.brq.projeto_carteira_virtutal.R

open class TerceiraTela : AppCompatActivity() {

    var valorDaSegundaTela = 0.0
    lateinit var valorDaTerceiraTela: Editable
    var valorDaTerceiraTelaDouble = 0.0
    lateinit var entradaValor: EditText
    lateinit var saidaValor: TextView
    lateinit var botao: ImageButton
    var somaSaldo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_tela)

        somaSaldo = intent.getStringExtra("somaSaldo")

        carregarElementos()
        carregarEventos()
    }


    fun carregarElementos() {
        entradaValor = findViewById(R.id.entrada_valor)
        saidaValor = findViewById(R.id.saida_valor)
        botao = findViewById(R.id.botao_entrada)
    }

    fun carregarEventos() {
        botao.setOnClickListener() {
            valorDaSegundaTela = somaSaldo.toString().toDouble()
            valorDaTerceiraTela = entradaValor.text
            valorDaTerceiraTelaDouble = valorDaTerceiraTela.toString().toDouble()
            var resultado = valorDaSegundaTela-valorDaTerceiraTelaDouble

            if(resultado < 0){
                saidaValor.text = ("R$ ${-resultado}0").toString()
            }
            else{
                saidaValor.text = "R$ 0,00"
            }
        }
    }
}