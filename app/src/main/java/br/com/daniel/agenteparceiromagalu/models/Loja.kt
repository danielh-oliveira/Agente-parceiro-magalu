package br.com.daniel.agenteparceiromagalu.models

data class Loja(
    private val id: Int = 0,
    val nome: String,
    val date: String,
    val tag: Enum<Tags>? = null
)
