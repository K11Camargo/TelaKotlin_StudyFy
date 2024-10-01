package br.senai.sp.jandira.telainicio.service

import br.senai.sp.jandira.telainicio.model.Aluno
import br.senai.sp.jandira.telainicio.model.Login
import br.senai.sp.jandira.telainicio.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface AlunoService {

    // Obter a lista de alunos (GET)
    @GET("alunos")
    fun getAlunos(): Call<List<Aluno>>  // Retorna uma lista de Aluno

    // Obter um aluno pelo ID (GET)
    @GET("alunos/{id}")
    fun getAlunoById(@Path("id") id: Int): Call<Aluno>  // Retorna um único Aluno pelo ID

    @Headers("Content-Type: application/json")
    @POST("login")
    fun getAlunoByEmailSenha(@Body EmailSenha: Login): Call<LoginResponse>

    // Enviar um novo aluno (POST)
    @Headers("Content-Type: application/json")
    @POST("aluno")
    fun postAluno(@Body alunoPost: Aluno): Call<Aluno>  // Envia um AlunoPost e recebe um Aluno (com id gerado)
}
