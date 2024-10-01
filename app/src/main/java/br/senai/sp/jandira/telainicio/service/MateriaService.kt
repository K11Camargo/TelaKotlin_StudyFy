package br.senai.sp.jandira.telainicio.service

import br.senai.sp.jandira.telainicio.model.Aluno
import br.senai.sp.jandira.telainicio.model.Professor
import retrofit2.Call
import br.senai.sp.jandira.telainicio.model.ResultMateria
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface MateriaService {

    @GET("materia")
    fun getAllMaterias(): Call<ResultMateria>

}