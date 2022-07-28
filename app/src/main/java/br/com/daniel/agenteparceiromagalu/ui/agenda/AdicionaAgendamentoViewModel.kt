package br.com.daniel.agenteparceiromagalu.ui.agenda

import androidx.lifecycle.ViewModel
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.repository.Repositorio

class AdicionaAgendamentoViewModel : ViewModel() {

    private val repositorio by lazy { Repositorio() }

    fun salvarAgendamento(loja: Loja) {
        repositorio.adiciona(loja)
    }

}