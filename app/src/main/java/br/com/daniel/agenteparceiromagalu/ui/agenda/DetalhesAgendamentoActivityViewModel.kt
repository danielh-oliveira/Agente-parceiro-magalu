package br.com.daniel.agenteparceiromagalu.ui.agenda

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.daniel.agenteparceiromagalu.model.Loja

class DetalhesAgendamentoActivityViewModel : ViewModel() {
    fun nomeLoja(): String {
        //TODO pegar nome no banco de dados
        return "Nome de loja place holder"
    }

    fun dataAgendada(): String {
        //TODO pegar data no banco de dados
        return "Data place holder"
    }

    fun horaAgendada(): String {
        //TODO pegar hora em variavel local
        return "Hora place holder"
    }

    fun telefoneLoja(): String {
        //TODO pegar telefone no banco de dados
        return "21999999999 place holder"
    }

    fun tagAgendamento(): String {
        //TODO pegar tag no banco de dados
        return "Tag place holder"
    }

}