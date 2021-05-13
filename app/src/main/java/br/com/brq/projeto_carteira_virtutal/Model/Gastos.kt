package br.com.brq.projeto_carteira_virtutal.Model

import java.io.Serializable

open class Gastos(val valor: Double): Serializable {
    fun validaValor(): Boolean{
        return valor != null
    }
}