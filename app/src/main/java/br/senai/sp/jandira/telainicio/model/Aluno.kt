package br.senai.sp.jandira.telainicio.model

data class Aluno(
    val nome: String,
    val email: String,
    val senha: String,
    val telefone: String,
    val data_nascimento: String,
    val serie: String,
    val materias: List<Int>
)
