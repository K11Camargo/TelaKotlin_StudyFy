package br.senai.sp.jandira.telainicio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import br.senai.sp.jandira.telainicio.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MudarSenha(controleDeNavegacao: NavHostController? = null){

    var SenhaAtual = remember { mutableStateOf("") }
    var NovaSenha = remember { mutableStateOf("") }
    var ConfirmarNovaSenha = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFFEE101))
    ) {

        Column(
            modifier = Modifier
                .padding(top = 35.dp)
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(140.dp),
                painter = painterResource(id = R.drawable.calabreso2),
                contentDescription = "Mascote"
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF302F2F),
                fontSize = 30.sp,
                text = "Mudar senha"
            )
        }

        // Fundo inferior
        Box(
            modifier = Modifier
                .offset(y = 120.dp)
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
                .padding(start = 20.dp, top = 10.dp)
                .height(430.dp)
                .width(310.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                text = "Insira sua senha atual e altere-a"
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = SenhaAtual.value,
                    onValueChange = { SenhaAtual.value = it },
                    label = {
                        Text(
                            text = "Senha atual",
                            color = Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp), // Altura mínima recomendada
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = NovaSenha.value,
                    onValueChange = { NovaSenha.value = it },
                    label = {
                        Text(
                            text = "Nova senha",
                            color = Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = ConfirmarNovaSenha.value,
                    onValueChange = { ConfirmarNovaSenha.value = it },
                    label = {
                        Text(
                            text = "Confirmar senha",
                            color = Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray
                    )
                )
            }

            Spacer(modifier = Modifier.height(70.dp))

            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .width(180.dp)
                        .height(70.dp)
                        .align(alignment = Alignment.Center),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFEE101))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "Mudar senha",
                            fontSize = 19.sp,
                            color = Color.Black
                        )

                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MudarSenhaPreview() {
    MudarSenha()
}
