package br.senai.sp.jandira.telainicio.model

data class Professor(
    val id: Int,
    val nome: String = "",
    val email: String = "",
    val senha: String = "",
    val telefone: String = ""
)
