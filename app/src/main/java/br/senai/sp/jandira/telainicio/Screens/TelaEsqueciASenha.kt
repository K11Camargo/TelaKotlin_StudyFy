package br.senai.sp.jandira.telainicio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.telainicio.R
import org.w3c.dom.Text
import java.time.format.TextStyle

@Composable
fun TelaEsqueciASenha() {
    Surface(
        color = Color(0xFFFFEE101)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp)
                .height(400.dp),


            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Image(
                modifier = Modifier
                    .size(height = 113.dp, width = 98.dp),


                painter = painterResource(id = R.drawable.calabreso2),
                contentDescription = "Calabreso"
            )


            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .width(800.dp)
                    .height(700.dp)
            ){
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Esqueceu sua senha? Não se preocupe!",
                    )
                    Spacer(modifier = Modifier.padding(10.dp))


                    Text( fontSize = 20.sp,
                        text = "Informe seu email para que \npossamos enviar a sua senha \ne digite o código recebido"
                    )


                    Spacer(modifier = Modifier.padding(10.dp))
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /*TODO*/ },
                        label = { Text("Informe o E-mail cadastrado") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFFE9CE03), // Cor daborda quando o campo está focado
                            unfocusedBorderColor = Color(0xFFFE9CE03) // Cor da borda quando o campo não está focado
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )


                    Spacer(modifier = Modifier.padding(10.dp))
                    Row {
                        OutlinedTextField( modifier = Modifier
                            .width(160.dp)
                            .height(50.dp),
                            value = "",
                            onValueChange = { /*TODO*/ },
                            label = { Text(text = "Insira o código aqui") },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFFFE9CE03), // Cor daborda quando o campo está focado
                                unfocusedBorderColor = Color(0xFFFE9CE03) // Cor da borda quando o campo não está focado
                            ),
                            shape = RoundedCornerShape(20.dp)


                        )


                        Button(onClick = { /*TODO*/ },
                            modifier = Modifier.padding(5.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFFE9CE03))
                        ){
                            Text(text = "Enviar e-mail",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }


                    Spacer(modifier = Modifier.padding(75.dp))
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.padding(5.dp).height(50.dp).width(200.dp).align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(Color(0xFFFE9CE03))
                    ){
                        Text(text = "Recuperar senha",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                    Text(text = "Voltar a tela de login",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.
                        align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}








@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaEsqueciASenhaPreview() {
        TelaEsqueciASenha()
}