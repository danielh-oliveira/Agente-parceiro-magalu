package br.com.daniel.agenteparceiromagalu.ui.agenda

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import br.com.daniel.agenteparceiromagalu.databinding.ActivityChecklistBinding

class ChecklistActivity : AppCompatActivity() {

    private val binding by lazy { ActivityChecklistBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}