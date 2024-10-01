package br.senai.sp.jandira.telainicio.model

data class Login(
    val email: String = "",
    val senha: String = "",
)

data class LoginResponse(
    val usuario_id: Int?,
    val status_code: Int?,
    val message: String?
)
