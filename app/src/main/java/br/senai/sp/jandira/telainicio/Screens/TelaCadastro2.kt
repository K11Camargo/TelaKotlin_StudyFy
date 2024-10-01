package br.senai.sp.jandira.telainicio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun TelaCadastro2(controleDeNavegacao: NavHostController?= null) {
    val days = (1..31).map { it.toString() }
    val months = listOf("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro")
    val years = (1900..2024).map { it.toString() }
    var selectedDay by remember { mutableStateOf<String?>(null) }
    var selectedMonth by remember { mutableStateOf<String?>(null) }
    var selectedYear by remember { mutableStateOf<String?>(null) }

    var expandedMonth by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFFEE101))
    ) {
        Box(
            modifier = Modifier
                .padding(top = 35.dp)
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
                .width(130.dp)
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
                text = "Cadastro",
                modifier = Modifier
                    .offset(x = 4.dp, y = 130.dp)
            )
        }
        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = 280.dp)
                .height(300.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFEEEEEE))
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
                .fillMaxHeight()
                .width(350.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 30.dp),
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    text = "Em que ano você nasceu?"
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 30.dp)
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Text(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    text = "Data de nascimento"
                )
                Box(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .height(250.dp)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .height(15.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 30.dp)
                                .width(80.dp),
                            text = "Dia"
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 130.dp)
                                .width(80.dp),
                            text = "Mês"
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 245.dp)
                                .width(80.dp),
                            text = "Ano"
                        )
                    }
                    Row (
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .height(150.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            trailingIcon = {
                                IconButton(onClick = {}) {}
                            },
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .height(55.dp)
                                .width(80.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color(0xFFFEE101),
                                unfocusedLabelColor = Color(0xFFFEE101),
                                unfocusedBorderColor = Color(0xFFFEE101)
                            ),
                            placeholder = {}
                        )

                        ExposedDropdownMenuBox(
                            expanded = expandedMonth,
                            onExpandedChange = { expandedMonth = !expandedMonth },
                            modifier = Modifier
                                .height(55.dp)
                                .width(120.dp)
                                .offset(x = 0.dp, y = -3.5.dp)
                        ) {
                            OutlinedTextField(
                                value = selectedMonth ?: "",
                                onValueChange = { },
                                readOnly = true,
                                label = { Text("") },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Filled.KeyboardArrowDown,
                                        contentDescription = "Expand menu",
                                        tint = Color(0xFFFEE101)
                                    )
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .height(55.dp)
                                    .padding(start = 10.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    containerColor = Color.Transparent,
                                    focusedLabelColor = Color(0xFFFEE101),
                                    unfocusedLabelColor = Color(0xFFFEE101),
                                    unfocusedBorderColor = Color(0xFFFEE101)
                                )
                            )
                            ExposedDropdownMenu(
                                expanded = expandedMonth,
                                onDismissRequest = { expandedMonth = false }
                            ) {
                                months.forEach { month ->
                                    DropdownMenuItem(
                                        text = { Text(month) },
                                        onClick = {
                                            selectedMonth = month
                                            expandedMonth = false
                                        }
                                    )
                                }
                            }
                        }


                        OutlinedTextField(
                            trailingIcon = {
                                IconButton(onClick = {}) {}
                            },
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .height(55.dp)
                                .width(100.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color(0xFFFEE101),
                                unfocusedLabelColor = Color(0xFFFEE101),
                                unfocusedBorderColor = Color(0xFFFEE101)
                            ),
                            placeholder = {}
                        )
                    }
                }
            }
            Button(
                onClick = {controleDeNavegacao?.navigate("cadastroprof")},
                colors = ButtonDefaults.buttonColors(Color(0xFFFEE101)),
                modifier = Modifier
                    .offset(x = 160.dp, y = 60.dp)
                    .width(180.dp)
                    .height(40.dp)
            ) {
                Text(
                    text = "Prox. passo",
                    color = Color.Black,
                    letterSpacing = 1.sp
                )
                Icon(
                    modifier = Modifier.padding(start = 30.dp),
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaCadastro2Preview() {
    TelaCadastro2()
}