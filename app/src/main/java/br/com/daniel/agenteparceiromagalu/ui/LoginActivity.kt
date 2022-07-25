package br.com.daniel.agenteparceiromagalu.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import br.com.daniel.agenteparceiromagalu.databinding.ActivityLoginBinding
import br.com.daniel.agenteparceiromagalu.util.dataStore
import br.com.daniel.agenteparceiromagalu.util.usuarioLogadoPreferences
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //TODO implementar login

        binding.buttonEntrar.setOnClickListener {
            val email = binding.textFieldEmail.editText!!.text
            val senha = binding.textFieldSenha.editText!!.text

            if (!(email.isNullOrBlank()) && !(senha.isNullOrBlank())) {
                lifecycleScope.launch {
                    dataStore.edit { preferences ->
                        preferences[usuarioLogadoPreferences] = "123456"
                    }
                }
                loginConcluido()
            } else {
                Toast.makeText(this, "E-mail e/ou senha vazio", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun loginConcluido() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}