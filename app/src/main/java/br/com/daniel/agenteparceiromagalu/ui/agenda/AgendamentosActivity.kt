package br.com.daniel.agenteparceiromagalu.ui.agenda

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.daniel.agenteparceiromagalu.R
import br.com.daniel.agenteparceiromagalu.ui.adapter.AgendaVisitasAdapter
import br.com.daniel.agenteparceiromagalu.databinding.ActivityAgendamentoBinding
import br.com.daniel.agenteparceiromagalu.ui.adapter.RecyclerViewInterface

class AgendamentosActivity : AppCompatActivity(), RecyclerViewInterface {
    private val binding by lazy { ActivityAgendamentoBinding.inflate(LayoutInflater.from(this)) }
    private val agendamentoViewModel: AgendamentosViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        ---------- inicio Configura appbar quando terminar extrair para função

        binding.topAppBarAgenda.setNavigationOnClickListener {
            finish()
        }

        binding.topAppBarAgenda.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_menu_adicionar -> {
                    startActivity(Intent(this, AdicionaAgendamentoActivity::class.java))
                    true
                }
                R.id.item_menu_filtro -> {
                    //TODO comportamento de filtro
                    true
                }
                else -> false
            }
        }

        //  ---------- final Configura appbar quando terminar extrair para função

        //  ---------- inicio configura adapter com livedata
        val listaLojasLivedata = agendamentoViewModel.createFakeData()
        listaLojasLivedata.observe(this, Observer {
            binding.rvAgenda.adapter = AgendaVisitasAdapter(it, this)
        })
        //  ---------- final configura adapter com livedata
    }

    override fun onItemClick(position: Int) {
        Intent(this, DetalhesAgendamentoActivity::class.java).apply {
            putExtra("POSICAO", position)
        }.let { startActivity(it) }
    }
}