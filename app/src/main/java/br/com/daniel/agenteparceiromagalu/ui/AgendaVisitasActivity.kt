package br.com.daniel.agenteparceiromagalu.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import br.com.daniel.agenteparceiromagalu.R
import br.com.daniel.agenteparceiromagalu.adapter.AgendaVisitasAdapter
import br.com.daniel.agenteparceiromagalu.databinding.ActivityAgendaVisitasBinding
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.model.Tags
import java.time.LocalDateTime

class AgendaVisitasActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAgendaVisitasBinding.inflate(LayoutInflater.from(this)) }

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
                    //TODO comportamento de adicionar


                    true
                }
                R.id.item_menu_filtro -> {
                    //TODO comportamento de filtro

                    true
                }
                else -> false
            }
        }

        //        ---------- final Configura appbar quando terminar extrair para função

        val listaLojas = createFakeData()

        binding.rvAgenda.adapter = AgendaVisitasAdapter(listaLojas)
    }

    //TODO resolver essa anotation
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createFakeData(): List<Loja> {
        val lista = mutableListOf<Loja>(
            Loja(nome = "Casas Bahia", date = LocalDateTime.now().toString(), tag = Tags.Eletronicos),
            Loja(nome = "Itau", date = LocalDateTime.now().toString()),
            Loja(nome = "Casas Cleide", date = LocalDateTime.now().toString()),
            Loja(nome = "Moveis Bahia", date = LocalDateTime.now().toString(), tag = Tags.Departamento),
            Loja(nome = "Saraiva", date = LocalDateTime.now().toString(), tag = Tags.Livraria),
            Loja(nome = "Outbeco", date = LocalDateTime.now().toString())
        )
        return lista
    }
}