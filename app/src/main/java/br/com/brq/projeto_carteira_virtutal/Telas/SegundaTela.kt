package br.com.brq.projeto_carteira_virtutal.Telas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.brq.projeto_carteira_virtutal.R

class SegundaTela : AppCompatActivity() {
    lateinit var btnFlAdd : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)



        btnFlAdd.setOnClickListener(){

        }

    }


}