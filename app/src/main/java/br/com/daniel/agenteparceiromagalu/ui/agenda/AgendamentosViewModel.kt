package br.com.daniel.agenteparceiromagalu.ui.agenda

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.repository.Repositorio

class AgendamentosViewModel : ViewModel() {

    private val repositorio by lazy { Repositorio() }
    private val _agendamentoLojas = MutableLiveData<MutableList<Loja>>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun createFakeData(): LiveData<MutableList<Loja>> {

        _agendamentoLojas.value = repositorio.createFakeData()

        return _agendamentoLojas
    }
}