package br.com.brq.projeto_carteira_virtutal.Telas


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projeto_carteira_virtutal.Adapter
import br.com.brq.projeto_carteira_virtutal.Model.Gastos
import br.com.brq.projeto_carteira_virtutal.Model.Saldo
import br.com.brq.projeto_carteira_virtutal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


open class SegundaTela : AppCompatActivity() {

    /**VARIÁVEIS AUXILIAR DO CALCULO*/
    lateinit var aux: String

    /**VARIÁVEIS DO SALDO*/
    lateinit var valorNaTelaSaldo: CharSequence
    var valorNaTelaSaldoDouble = 0.0
    lateinit var entradaSaldo: EditText
    lateinit var botaoSaldoAdd: FloatingActionButton
    lateinit var botaoSaldoLimpar: Button
    lateinit var somaSaldo: TextView

    /**VARIÁVEIS DO GASTO*/
    lateinit var valorNaTelaGasto: CharSequence
    var valorNaTelaGastoDouble = 0.0
    lateinit var valorGasto: EditText
    lateinit var botaoGastosAdd: FloatingActionButton
    lateinit var botaoGastosLimpar: Button
    lateinit var somaGastos: TextView

    /**VARIÁVEIS DO RECYCLER VIEW*/
    lateinit var recycler: RecyclerView
    lateinit var adapter: Adapter

    /**VARIÁVEL DO COFRINHO*/
    lateinit var cofrinho: ImageButton

    /**VARIÁVEL DA LISTA*/
    lateinit var listaDeGastos: ArrayList<Gastos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        carregarElementos()
        carregarEventos()
        carregarArray()

        Adapter(this, listaDeGastos, null).let {
            adapter = it
            recycler.adapter = it
        }

        recycler.layoutManager = LinearLayoutManager(this)
    }


    fun carregarElementos() {
        /**VARIÁVEIS DO SALDO*/
        entradaSaldo = findViewById(R.id.entrada_valor)
        botaoSaldoAdd = findViewById(R.id.botao_saldo_add)
        botaoSaldoLimpar = findViewById(R.id.limpar_saldo)
        somaSaldo = findViewById(R.id.soma_saldo)
        /**VARIÁVEIS DO GASTO*/
        valorGasto = findViewById(R.id.novo_gasto)
        botaoGastosAdd = findViewById(R.id.botao_gastos_add)
        botaoGastosLimpar = findViewById(R.id.limpar_gastos)
        somaGastos = findViewById(R.id.soma_gastos)
        /**VARIÁVEL DO COFRINHO*/
        cofrinho = findViewById(R.id.cofrinho)
        /**VARIÁVEL DO RECYCLER VIEW*/
        recycler = findViewById(R.id.gastos)
    }

    fun carregarEventos() {
        /**EVENTOS DO SALDO*/
        botaoSaldoAdd.setOnClickListener() {
            if (entradaSaldo.text.isEmpty()) {
                entradaSaldo.error = "ERRO"
            } else {
                valorNaTelaSaldo = somaSaldo.text
                var saldo = Saldo(entradaSaldo.text.toString().toDouble())
                valorNaTelaSaldoDouble = valorNaTelaSaldo.toString().toDouble()
                somaSaldo.text = (valorNaTelaSaldoDouble + saldo.valor).toString()
            }
        }
        botaoSaldoLimpar.setOnClickListener() {
            somaSaldo.setText("0")
        }
        /**EVENTOS DOS GASTOS*/
        botaoGastosAdd.setOnClickListener() {
            if (valorGasto.text.isEmpty()) {
                valorGasto.error = "ERRO"
            } else {
                valorNaTelaGasto = somaGastos.text
                var gastos = Gastos(valorGasto.text.toString().toDouble())
                valorNaTelaGastoDouble = valorNaTelaGasto.toString().toDouble()
                somaGastos.text = (valorNaTelaGastoDouble + gastos.valor).toString()
                aux = ((somaSaldo.text.toString().toDouble()) - gastos.valor).toString()
                somaSaldo.text = aux
                /**PARTE DO ADAPTER*/
                adapter.addItem(Gastos(valorGasto.text.toString().toDouble()))
            }
        }
        botaoGastosLimpar.setOnClickListener() {
            somaGastos.setText("0")
            if (listaDeGastos.size == 0) {
            } else {
                adapter.removeItem(0)
            }
        }
        /**PARTE DO COFRINHO*/
        cofrinho.setOnClickListener(){
            val intent = Intent(this, TerceiraTela::class.java)
            intent.putExtra("somaSaldo", somaSaldo.text)
            startActivity(Intent(this, TerceiraTela::class.java))
        }
    }

    fun carregarArray() {
        listaDeGastos = ArrayList()
    }
}

