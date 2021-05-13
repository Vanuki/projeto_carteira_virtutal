package br.com.brq.projeto_carteira_virtutal.Telas


import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projeto_carteira_virtutal.Adapter
import br.com.brq.projeto_carteira_virtutal.Model.Gastos
import br.com.brq.projeto_carteira_virtutal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SegundaTela : AppCompatActivity(){


    lateinit var botaoSaldoAdd: FloatingActionButton
    lateinit var botaoGastosAdd: FloatingActionButton
    lateinit var valor: EditText
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
            adapter.addItem(Gastos(valor.text.toString().toDouble()))
        }
    }

    fun carregarElementos() {
        valor = findViewById(R.id.novo_gasto)
        botaoSaldoAdd = findViewById(R.id.botaoSaldoAdd)
        botaoGastosAdd = findViewById(R.id.botaoGastosAdd)
        recycler = findViewById(R.id.gastos)
    }

    fun carregarArray() {
        listaDeGastos = ArrayList()
    }
}

