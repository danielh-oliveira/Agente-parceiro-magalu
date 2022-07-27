package br.com.daniel.agenteparceiromagalu.model

data class Loja(
    private val id: Int = 0,
    val nome: String,
    val date: String,
    val telefone: Double,
    val tag: Enum<Tags>? = null
)
