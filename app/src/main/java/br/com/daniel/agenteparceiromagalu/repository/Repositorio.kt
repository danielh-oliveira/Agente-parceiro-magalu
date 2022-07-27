package br.com.daniel.agenteparceiromagalu.repository

import android.os.Build
import androidx.annotation.RequiresApi
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.model.Tags
import java.time.LocalDateTime

class Repositorio {

    companion object {
        lateinit var lista: MutableList<Loja>
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createFakeData(): MutableList<Loja> {
        lista = mutableListOf(
            Loja(
                nome = "Casas Bahia",
                date = LocalDateTime.now().toString(),
                tag = Tags.Eletronicos,
            telefone = 21.22222222
            ),
            Loja(nome = "Itau", date = LocalDateTime.now().toString(),telefone = 21.33333333),
            Loja(nome = "Casas Cleide", date = LocalDateTime.now().toString(),telefone = 21.99999999),
            Loja(
                nome = "Moveis Bahia",
                date = LocalDateTime.now().toString(),
                tag = Tags.Departamento,
                telefone = 21.44444444
            ),
            Loja(nome = "Saraiva", date = LocalDateTime.now().toString(), tag = Tags.Livraria, telefone = 21.55555555),
            Loja(nome = "Outbeco", date = LocalDateTime.now().toString(), telefone = 21.66666666)
        )

        return lista
    }

    fun getLoja(position: Int): Loja {
        return lista[position]
    }

}