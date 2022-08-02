package br.com.daniel.agenteparceiromagalu.ui.agenda

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.daniel.agenteparceiromagalu.R
import br.com.daniel.agenteparceiromagalu.databinding.ActivityDetalheAgendamentoBinding
import br.com.daniel.agenteparceiromagalu.model.Loja

class DetalhesAgendamentoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetalheAgendamentoBinding.inflate(LayoutInflater.from(this)) }
    private val detalhesAgendViewModel: DetalhesAgendamentoActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val position = intent.getIntExtra("POSICAO", -1).also {
            if (it == -1) {
                finish()
            }
        }

        configuraButtonNavigation()
        configuraCamposTexto(position)
        configuraActivityButtons()


    }

    private fun configuraActivityButtons() {
        binding.chamadaButton.setOnClickListener {
            iniciaTelefone()
        }
        binding.abrirChecklistButton.setOnClickListener {
            startActivity(Intent(this, ChecklistActivity::class.java))
        }
    }


    @SuppressLint("QueryPermissionsNeeded") //Não precisamos por <queries> no manifesto porque o telefone é visivel
    private fun iniciaTelefone() {
        /* Pode ser que o android não tenha um app capaz de lidar com uma
            * ligação então usando o resolveActivity na sua intent faz
            * verificar se possui */
        val intentTelefone = Intent(Intent.ACTION_DIAL).apply {
            val telefone = detalhesAgendViewModel.getChamada()
            data = Uri.parse("tel:$telefone")
        }
        if (intentTelefone.resolveActivity(packageManager) != null) {
            startActivity(intentTelefone)
        } else {
            Toast.makeText(this, getString(R.string.call_error), Toast.LENGTH_SHORT).show()
        }
    }

    private fun configuraCamposTexto(position: Int) {
        val loja: Loja = detalhesAgendViewModel.getDetalhes(position)

        binding.nomeLojaDetalhe.text = detalhesAgendViewModel.nomeLoja()
        binding.dataDetalhe.text = detalhesAgendViewModel.dataAgendada()
        binding.horaDetalhe.text = detalhesAgendViewModel.horaAgendada()
        binding.telefoneDetalhe.text = detalhesAgendViewModel.telefoneLoja()
        binding.tagDetalhe.text = detalhesAgendViewModel.tagAgendamento()
    }

    private fun configuraButtonNavigation() {
        binding.topAppBarDetalhes.setNavigationOnClickListener {
            finish()
        }
    }
}