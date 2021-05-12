package br.com.brq.projeto_carteira_virtutal.Model


class User(val email: String, val senha: String) {

    fun validarEmail():Boolean{
        return email == ""
    }

    fun validarSenha():Boolean{
        return senha == ""
    }
}