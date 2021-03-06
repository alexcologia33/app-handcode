package com.handcode.app.apphandcode.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.handcode.app.apphandcode.R
import com.handcode.app.apphandcode.model.Usuario
import com.handcode.app.apphandcode.service.LocalStore

class NotasActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notas)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Notas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
    }

    private fun configuraMenuLateral(){
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var menuLateral = findViewById<DrawerLayout>(R.id.layoutMenuLateral)

        var toogle = ActionBarDrawerToggle (
                this,
                menuLateral,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)

        menuLateral.addDrawerListener(toogle)
        toogle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.menu_lateral)
        navigationView.setNavigationItemSelectedListener(this)

        val n = navigationView.getHeaderView(0).findViewById<TextView>(R.id.nomeUsuario)

        val u = LocalStore.data.get("usuario") as Usuario

        n.text = u.nome
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navPainelAluno -> {
                val intent = Intent(context, PainelAlunoActivity::class.java)
                startActivity(intent)

                Toast.makeText(this, "Painel do Aluno", Toast.LENGTH_SHORT).show()
            }
            R.id.navEntregas -> {
                val intent = Intent(context, EntregasActivity::class.java)
                startActivity(intent)

                Toast.makeText(this, "Entregas Realizadas", Toast.LENGTH_SHORT).show()
            }
            R.id.navEntregasPendentes -> {
                val intent = Intent(context, EntregasPendentesActivity::class.java)
                startActivity(intent)

                Toast.makeText(this, "Entregas Pendentes", Toast.LENGTH_SHORT).show()
            }
            R.id.navEnviarDocs -> {
                val intent = Intent(context, EnviarDocumentosActivity::class.java)
                startActivity(intent)

                Toast.makeText(this, "Enviar Documentos", Toast.LENGTH_SHORT).show()
            }
            R.id.navNotas -> {

                Toast.makeText(this, "Notas", Toast.LENGTH_SHORT).show()
            }
            R.id.navSair -> {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                finishAndRemoveTask()

            }
        }


        val drawer = findViewById<DrawerLayout>(R.id.layoutMenuLateral)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.actionBuscar) {
            Toast.makeText(context, "Botão de buscar",
                    Toast.LENGTH_LONG).show()
        } else if (id == R.id.actionAtualizar) {
            Toast.makeText(context, "Botão de atualizar",
                    Toast.LENGTH_LONG).show()
        } else if (id == R.id.actionConfig) {
            val intent = Intent(context, ConfiguracoesActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.actionSair) {
            val returnIntent = Intent()
            setResult(1, returnIntent)
            finish()
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
