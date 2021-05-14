package br.com.brq.projeto_carteira_virtutal.Telas


import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projeto_carteira_virtutal.Adapter
import br.com.brq.projeto_carteira_virtutal.Model.Gastos
import br.com.brq.projeto_carteira_virtutal.Model.Saldo
import br.com.brq.projeto_carteira_virtutal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SegundaTela : AppCompatActivity(){

    lateinit var botaoSaldoAdd: FloatingActionButton
    lateinit var botaoGastosAdd: FloatingActionButton
    lateinit var valorGasto: EditText
    lateinit var entradaSaldo: EditText
    lateinit var somaSaldo: TextView
    lateinit var recycler: RecyclerView
    lateinit var adapter: Adapter
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

    fun carregarEventos() {
        botaoGastosAdd.setOnClickListener() {
            if(valorGasto.text.isEmpty()){
                valorGasto.error = "ERRO"
            }
            else{
                adapter.addItem(Gastos(valorGasto.text.toString().toDouble()))
            }
        }
        botaoSaldoAdd.setOnClickListener() {
            if(entradaSaldo.text.isEmpty()){
                entradaSaldo.error = "ERRO"
            }
            else{
                var valorNaTela = somaSaldo.text
                var saldo = Saldo(entradaSaldo.text.toString().toDouble())
                if(valorNaTela.isEmpty() && valorNaTela == "0"){
                    somaSaldo.text = saldo.valor.toString()
                }
                else{
                    var valorNaTelaDouble = valorNaTela.toString().toDouble()
                    somaSaldo.text = (valorNaTelaDouble + saldo.valor).toString()
                }

            }
        }
    }

    fun carregarElementos() {
        entradaSaldo = findViewById(R.id.novo_saldo)
        botaoSaldoAdd = findViewById(R.id.botaoSaldoAdd)
        somaSaldo = findViewById(R.id.soma_saldo)

        valorGasto = findViewById(R.id.novo_gasto)
        botaoGastosAdd = findViewById(R.id.botaoGastosAdd)

        recycler = findViewById(R.id.gastos)
    }

    fun carregarArray() {
        listaDeGastos = ArrayList()
    }
}

