package br.com.daniel.agenteparceiromagalu.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import br.com.daniel.agenteparceiromagalu.databinding.ActivityMainBinding
import br.com.daniel.agenteparceiromagalu.util.dataStore
import br.com.daniel.agenteparceiromagalu.util.usuarioLogadoPreferences
import kotlinx.coroutines.launch

//Material components https://material.io/components?platform=android

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonAgendaVisita.setOnClickListener {
            startActivity(Intent(this, AgendaVisitasActivity::class.java))
        }

        binding.opcoes.setOnClickListener {
            lifecycleScope.launch {
                dataStore.edit { preferences ->
                    preferences[usuarioLogadoPreferences] = " "
                }
            }
        }

        lifecycleScope.launch {
            dataStore.data.collect { preferences ->
                preferences[usuarioLogadoPreferences]?.let {
                    if (it.isBlank()) {
                        vaiParaLogin()
                    }
                } ?: vaiParaLogin()
            }
        }

    }

    private fun vaiParaLogin() {
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        finish()
    }
}