package br.com.brq.projeto_carteira_virtutal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projeto_carteira_virtutal.Model.Gastos

class Adapter(
        val context: Context,
        val listaDeGastos: ArrayList<Gastos>,
        val onClick: ItemClickListener? = null
) : RecyclerView.Adapter<ViewHolderGastos>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGastos {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_da_lista, parent, false)
        return ViewHolderGastos(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolderGastos, position: Int) {
        listaDeGastos[position].also {
            holder.textViewValor.text = it.valor

        }
    }

    override fun getItemCount(): Int {
        return listaDeGastos.size
    }

    fun addItem(gasto: Gastos) {
        listaDeGastos.add(gasto)
        notifyDataSetChanged()
    }

    fun removeItem(index: Int) {
        listaDeGastos.removeAt(index)
        notifyDataSetChanged()
    }
}

class ViewHolderGastos(itemView: View, private val nossaInterface: ItemClickListener?) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    var textViewValor: TextView

    init {
        textViewValor = itemView.findViewById(R.id.textViewValor)

        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        nossaInterface?.onClickItem(v, adapterPosition)
    }

    override fun onLongClick(v: View?): Boolean {
        nossaInterface?.onLongClickItem(v, adapterPosition)
        return true
    }

}

interface ItemClickListener {

    fun onClickItem(view: View?, index: Int)
    fun onLongClickItem(view: View?, index: Int)

}