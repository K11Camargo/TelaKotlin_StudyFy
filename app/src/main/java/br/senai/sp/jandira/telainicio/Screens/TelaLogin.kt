package br.senai.sp.jandira.telainicio.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.rickandmorty.service.RetrofitFactory
import br.senai.sp.jandira.telainicio.R
import br.senai.sp.jandira.telainicio.model.Login
import br.senai.sp.jandira.telainicio.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(controleDeNavegacao: NavHostController? = null) {
    var UsuarioEmail = remember { mutableStateOf("") }
    var UsuarioSenha = remember { mutableStateOf("") }
    var UsuarioEmailValida = remember { mutableStateOf("") }
    var UsuarioSenhaValida = remember { mutableStateOf("") }
    var messageErrorState by remember { mutableStateOf("") }
    var isErrorState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFFEE101))
    ) {
        // Box do login com imagem e título
        Box(
            modifier = Modifier
                .padding(top = 35.dp)
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
                .width(100.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(140.dp)
                    .height(150.dp)
                    .width(150.dp),
                painter = painterResource(id = R.drawable.calabreso2),
                contentDescription = "Mascote"
            )
            Text(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                color = Color(0xFF302F2F),
                text = "Login",
                modifier = Modifier.offset(x = 10.dp, y = 130.dp)
            )
        }

        // Fundo inferior
        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = 280.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color(0xFFEEEEEE))
                .align(Alignment.CenterHorizontally)
        )
    }

    Box(
        modifier = Modifier
            .offset(x = 20.dp, y = 250.dp)
            .background(Color.White)
            .height(500.dp)
            .width(350.dp)
            .zIndex(1f)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 30.dp)
                .height(430.dp)
                .width(310.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                text = "Por favor, faça login para continuar"
            )

            OutlinedTextField(
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Caixa",
                            tint = Color(0xFFFEE101)
                        )
                    }
                },
                value = UsuarioEmail.value,
                onValueChange = { UsuarioEmail.value = it },
                modifier = Modifier
                    .padding(top = 30.dp)
                    .width(350.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedBorderColor = Color(0xFFFEE101),
                    unfocusedBorderColor = Color(0xFFFEE101)
                ),
                placeholder = {
                    Text(text = "E-mail", color = Color.Black)
                }
            )

            OutlinedTextField(
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Caixa",
                            tint = Color(0xFFFEE101)
                        )
                    }
                },
                value = UsuarioSenha.value,
                onValueChange = { UsuarioSenha.value = it },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(350.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedBorderColor = Color(0xFFFEE101),
                    unfocusedBorderColor = Color(0xFFFEE101)
                ),
                placeholder = {
                    Text(text = "Senha", color = Color.Black)
                }
            )

            Text(
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Light,
                text = "Esqueceu a senha?"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row {
                Text(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black,
                    text = "Ou cadastre-se com:"
                )
                Image(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(20.dp)
                        .width(20.dp),
                    painter = painterResource(id = R.drawable.googleimg),
                    contentDescription = "Google logo"
                )
            }

            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            ) {
                Text(text = messageErrorState, color = Color.Red)

                Button(
                    onClick = {
                        // Verificação de campos vazios
                        if (UsuarioEmail.value.isEmpty() || UsuarioSenha.value.isEmpty()) {
                            isErrorState = true
                            messageErrorState = "Não deve haver campos vazios"
                        } else if (UsuarioEmail.value.length > 255) {
                            isErrorState = true
                            messageErrorState = "O email não deve ultrapassar 255 caracteres"
                        } else if (UsuarioSenha.value.length < 6) {
                            isErrorState = true
                            messageErrorState = "A senha deve ser maior que 6 caracteres"
                        } else if (UsuarioSenha.value.length > 25) {
                            isErrorState = true
                            messageErrorState = "A senha não deve ser menor que 25"
                        } else {
                            val usuarioLogin = Login(
                                email = UsuarioEmail.value,
                                senha = UsuarioSenha.value
                            )

                            val call = RetrofitFactory().getAlunoService().getAlunoByEmailSenha(usuarioLogin)

                            call.enqueue(object : Callback<LoginResponse> {
                                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                                    if (response.isSuccessful) {
                                        val usuarioLogado = response.body()
                                        println("Aluno logado com sucesso:")
                                    } else {
                                        isErrorState = true
                                        messageErrorState = "Não foi encontrado nenhum usuario"
                                        println("Erro ao criar aluno: ${response.code()}")
                                    }
                                }

                                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                                    println("Erro: ${t.message}")
                                }
                            })
                        }
                    },
                    modifier = Modifier
                        .offset(x = 160.dp, y = 60.dp)
                        .width(150.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFEE101))
                ) {
                    Text(text = "Logar", color = Color.Black, letterSpacing = 1.sp)
                    Icon(
                        modifier = Modifier.padding(start = 20.dp),
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }

                Text(
                    modifier = Modifier.offset(x = 90.dp, y = 100.dp),
                    fontSize = 15.sp,
                    text = "Não tem uma conta?"
                )
                Text(
                    modifier = Modifier
                        .offset(x = 230.dp, y = 100.dp)
                        .clickable { controleDeNavegacao?.navigate("inicio2") },
                    color = Color(0xFFFEE101),
                    fontSize = 15.sp,
                    text = "Cadastre-se"
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaLoginPreview() {
    TelaLogin()
}
