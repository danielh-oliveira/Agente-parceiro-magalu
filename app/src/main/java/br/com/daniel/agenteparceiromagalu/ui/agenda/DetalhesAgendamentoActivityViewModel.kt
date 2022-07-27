package br.com.daniel.agenteparceiromagalu.ui.agenda

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.repository.Repositorio

class DetalhesAgendamentoActivityViewModel : ViewModel() {
    private val repositorio: Repositorio = Repositorio()
    private lateinit var loja: Loja

    fun getDetalhes(position: Int): Loja {
        loja = repositorio.getLoja(position)
        return loja
    }

    fun nomeLoja(): String {
        //TODO pegar nome no banco de dados
        return loja.nome
    }

    fun dataAgendada(): String {
        //TODO pegar data no banco de dados
        return loja.date
    }

    fun horaAgendada(): String {
        //TODO pegar hora em variavel local
        return loja.date
    }

    fun telefoneLoja(): String {
        //TODO pegar telefone no banco de dados
        val telefone = loja.telefone.toString()
        val telefoneindex = telefone.indexOf(".")
        val ddd = telefone.subSequence(0, telefoneindex).toString()
        val numero = telefone.subSequence(telefoneindex + 1, telefone.length).toString()

        return "($ddd) $numero"
    }

    fun tagAgendamento(): String {
        //TODO pegar tag no banco de dados
        return loja.tag?.toString() ?: "Sem tag"
    }

    fun getChamada(): String {
        val telefone = loja.telefone.toString().apply {
            removeSuffix(".")
        }
        return telefone
    }
}