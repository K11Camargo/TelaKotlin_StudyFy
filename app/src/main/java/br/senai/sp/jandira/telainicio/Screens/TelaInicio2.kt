package br.senai.sp.jandira.telainicio.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.navigation.NavHostController
import br.senai.sp.jandira.telainicio.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaInicio2(controleDeNavegacao: NavHostController? = null) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFFEE101))
    ) {

        Box (modifier = Modifier
            .padding(top = 40.dp)
            .align(Alignment.CenterHorizontally)
            .height(300.dp)
            .width(300.dp)
        ){
            Image(modifier = Modifier
                .size(340.dp)
                .height(250.dp)
                .width(50.dp),
                painter = painterResource(id = R.drawable.calabreso),
                contentDescription = "Mascote")
            Text(
                text = "StudyFy",
                modifier = Modifier
                    .offset(y = 200.dp)
                    .align(alignment = Alignment.Center),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold)





        }
        Text(
            text ="     Antes de começar seu cadastro, \nprecisamos saber se você é aluno ou professor.",
            modifier = Modifier
                .offset(y = 80.dp, x = 30.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold)



    }

    Box(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()

    ){
        Text(
            text = "Você é aluno ou professor?",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y=500.dp),
                 fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold)
        //botao aluno
        Button(
            onClick = { controleDeNavegacao?.navigate("cadastro1/professor") },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .offset(y = 600.dp)
                .align(Alignment.Center)
                .width(300.dp)
                .height(43.dp)

        ) {
            Text(
                text = "Professor",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 1.sp
            )


        }

        //botao professor
        Button(
            onClick = {controleDeNavegacao?.navigate("cadastro1/aluno")},
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .offset(y = 550.dp)
                .align(Alignment.Center)
                .width(300.dp)
                .height(43.dp)

        ) {
            Text(
                text = "Aluno",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 1.sp
            )


        }

    }





}



















@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaInicio2Preview() {
    TelaInicio2()

}