package br.com.daniel.agenteparceiromagalu.repository

import android.os.Build
import androidx.annotation.RequiresApi
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.model.Tags
import java.time.LocalDateTime

class Repositorio {

    @RequiresApi(Build.VERSION_CODES.O)
    fun createFakeData(): MutableList<Loja> {
        return mutableListOf(
            Loja(
                nome = "Casas Bahia",
                date = LocalDateTime.now().toString(),
                tag = Tags.Eletronicos
            ),
            Loja(nome = "Itau", date = LocalDateTime.now().toString()),
            Loja(nome = "Casas Cleide", date = LocalDateTime.now().toString()),
            Loja(
                nome = "Moveis Bahia",
                date = LocalDateTime.now().toString(),
                tag = Tags.Departamento
            ),
            Loja(nome = "Saraiva", date = LocalDateTime.now().toString(), tag = Tags.Livraria),
            Loja(nome = "Outbeco", date = LocalDateTime.now().toString())
        )
    }

}