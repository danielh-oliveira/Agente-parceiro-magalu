package br.com.daniel.agenteparceiromagalu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.daniel.agenteparceiromagalu.R
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.ui.agenda.RecyclerViewInterface

class AgendaVisitasAdapter(
    private val visitasAgendadas: List<Loja>,
    private val recyclerViewInterface: RecyclerViewInterface
) : RecyclerView.Adapter<AgendaVisitasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_lista_agenda, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val visita = visitasAgendadas.get(position)
        holder.vincula(visita, recyclerViewInterface)
    }

    override fun getItemCount(): Int = visitasAgendadas.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(visita: Loja, recyclerViewInterface: RecyclerViewInterface) {
            val nome = itemView.findViewById<TextView>(R.id.nomeLojaItem)
            val date = itemView.findViewById<TextView>(R.id.diaMesHoraItem)
            val tag = itemView.findViewById<TextView>(R.id.tagItem)

            nome.text = visita.nome
            date.text = visita.date
            tag.text = visita.tag?.toString() ?: "Sem Tag"

            itemView.setOnClickListener {
                recyclerViewInterface.onItemClick(adapterPosition)
            }
        }

    }
}