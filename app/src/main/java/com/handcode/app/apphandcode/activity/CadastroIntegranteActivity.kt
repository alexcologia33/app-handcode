package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.handcode.app.apphandcode.R
import kotlinx.android.synthetic.main.activity_cadastro_grupo.*
import kotlinx.android.synthetic.main.activity_cadastro_integrante.*

class CadastroIntegranteActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_integrante)
        buttonAddIntegrantes.setOnClickListener{cadastrarIntegrantes()}
        buttonFinalizar.setOnClickListener{finalizar()}
    }

    private fun finalizar() {
        val returnIntent = Intent()
        setResult(1, returnIntent)
        finish()
    }

    private fun cadastrarIntegrantes() {
        val intent = Intent(context, CadastroIntegranteActivity::class.java)
        startActivity(intent)
    }
}
