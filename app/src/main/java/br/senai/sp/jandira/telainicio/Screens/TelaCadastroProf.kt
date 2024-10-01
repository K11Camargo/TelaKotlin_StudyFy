package br.senai.sp.jandira.telainicio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
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
fun TelaCadastroProf(controleDeNavegacao: NavHostController?= null) {

    var especializacao by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFFEE101))
    ) {


        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
                .width(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.calabreso),
                contentDescription = "Mascote",
                modifier = Modifier
                    .size(130.dp)
                    .align(Alignment.Center)
                    .padding(bottom = 20.dp)
            )




            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color(0xFF302F2F),
                text = "Cadastre-se",
                modifier = Modifier
                    .offset(x = 15.dp, y = 150.dp)
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = 100.dp)
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
        Column(modifier = Modifier.padding(25.dp)) {
            Text(
                text = "Nos informe se você realmente é um professor",
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal,
            )

            Spacer(modifier = Modifier.height(100.dp))

            Column {
                OutlinedTextField(
                    trailingIcon = {
                        IconButton (onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Especialização",
                                tint = Color(0xFFFE9CE03)
                            )
                        }
                    },
                    value = especializacao,
                    onValueChange = {especializacao = it},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "especificação", color = Color.Black) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFFE9CE03),
                        unfocusedBorderColor = Color(0xFFFE9CE03)
                    )
                )
                Spacer(modifier = Modifier.height(100.dp))

                Row {
                    Button (
                        onClick = { controleDeNavegacao?.navigate("" )},
                        modifier = Modifier
                            .offset(x = 150.dp, y = 90.dp)
                            .height(50.dp)
                            .width(150.dp),
                        colors = buttonColors(
                            containerColor = Color(0xFFFE9CE03),
                        ),
                        shape = RoundedCornerShape(16.dp),
                    ) {

                        Text(text = "Cadastrar", color = Color.Black)

                        Spacer(modifier = Modifier.width(10.dp))

                        Icon(
                            imageVector = Icons.Filled.ArrowForward, // Replace with your desired icon
                            contentDescription = "Add",
                            tint = Color.Black
                        )

                    }
                }

            }
        }

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaCadastroProfPreview() {
    TelaCadastroProf()
}