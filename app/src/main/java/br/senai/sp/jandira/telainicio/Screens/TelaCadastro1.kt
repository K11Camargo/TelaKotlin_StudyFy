package br.senai.sp.jandira.telainicio.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import br.senai.sp.jandira.rickandmorty.service.RetrofitFactory
import br.senai.sp.jandira.telainicio.R
import br.senai.sp.jandira.telainicio.model.Aluno
import br.senai.sp.jandira.telainicio.model.Materia
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro1(
    controleDeNavegacao: NavHostController? = null,
    backStackEntry: NavBackStackEntry? = null // Adicione o parâmetro para capturar os argumentos de navegação
) {
    // Obtenha o parâmetro "tipoUsuario" da backStackEntry
    val tipoUsuario = backStackEntry?.arguments?.getString("tipoUsuario")

    // Variáveis de estado
    val aluno = remember { mutableStateOf(false) }
    val professor = remember { mutableStateOf(false) }

    println(tipoUsuario)


    // Atualize os estados de aluno e professor com base no tipo de usuário
    when (tipoUsuario) {
        "aluno" -> {
            aluno.value = true
            professor.value = false
        }
        "professor" -> {
            professor.value = true
            aluno.value = false
        }
    }

    var listaMateria by remember { mutableStateOf<List<Materia>>(emptyList()) }

    val materiasSelecionados = remember { mutableStateListOf<Boolean>() }

    LaunchedEffect(listaMateria) {
        // Limpa e adiciona false para cada nova matéria
        materiasSelecionados.clear()
        materiasSelecionados.addAll(List(listaMateria.size) { false })
    }

    val  nome = remember { mutableStateOf("") }
    val  email = remember { mutableStateOf("") }
    val  senha = remember { mutableStateOf("") }
    val  telefone = remember { mutableStateOf("") }

    // Variável de estado para controlar qual tela mostrar
    val etapa2 = remember { mutableStateOf(false) }
    val etapa3 = remember { mutableStateOf(false) }

//    // Estado das caixas de seleção
//    val mat = remember { mutableStateOf(false) }
//    val lp = remember { mutableStateOf(false) }
//    val his = remember { mutableStateOf(false) }
//    val fis = remember { mutableStateOf(false) }
//    val bio = remember { mutableStateOf(false) }
//    val qui = remember { mutableStateOf(false) }
//    val geo = remember { mutableStateOf(false) }
//    val filo = remember { mutableStateOf(false) }

    val meses = listOf(
        "Janeiro", "Fevereiro", "Março", "Abril",
        "Maio", "Junho", "Julho", "Agosto",
        "Setembro", "Outubro", "Novembro", "Dezembro"
    )

    val monthValues = mapOf(
        "Janeiro" to "01",
        "Fevereiro" to "02",
        "Março" to "03",
        "Abril" to "04",
        "Maio" to "05",
        "Junho" to "06",
        "Julho" to "07",
        "Agosto" to "08",
        "Setembro" to "09",
        "Outubro" to "10",
        "Novembro" to "11",
        "Dezembro" to "12"
    )

    var dia by remember { mutableStateOf(TextFieldValue("")) }
    var selectedMonth by remember { mutableStateOf("") }
    var monthValue by remember { mutableStateOf("") }
    var ano by remember { mutableStateOf(TextFieldValue("")) }

    var expandedMonth by remember { mutableStateOf(false) }

    var erroCadastroInfo by remember { mutableStateOf(false) }
    var messageErrorState by remember { mutableStateOf("") }




    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFFEE101))
    ) {

        // Logo e Título
        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
                .width(200.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(130.dp)
                    .align(Alignment.Center)
                    .padding(bottom = 20.dp),
                painter = painterResource(id = R.drawable.mascote),
                contentDescription = "Mascote"
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

        // Fundo cinza inferior
        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = 280.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color(0xFFEEEEEE))
                .align(Alignment.CenterHorizontally)
        )
    }

    // Box principal branco
    Box(
        modifier = Modifier
            .offset(x = 20.dp, y = 250.dp)
            .background(Color.White)
            .height(530.dp)
            .width(350.dp)
            .zIndex(1f)
    ) {
        if (!etapa2.value) {
            //etapa1
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 30.dp)
                    .height(830.dp)
                    .width(310.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Primeiro passo: Cadastro
                Text(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    text = "Para ter maior desempenho nos seus estudos",
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Campos de texto e email
                OutlinedTextField(
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Nome",
                                tint = Color(0xFFFEE101)
                            )
                        }
                    },
                    value = nome.value,
                    onValueChange = { nome.value = it},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.Transparent,
                        focusedBorderColor = Color(0xFFE9CE03),
                        unfocusedBorderColor = Color(0xFFE9CE03)
                    ),
                    label = { Text(text = "Nome", color = Color.Black) }
                )

                OutlinedTextField(
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email",
                                tint = Color(0xFFFEE101)
                            )
                        }
                    },
                    value = email.value,
                    onValueChange = { email.value = it},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.Transparent,
                        focusedBorderColor = Color(0xFFE9CE03),
                        unfocusedBorderColor = Color(0xFFE9CE03)
                    ),
                    label = { Text(text = "Email", color = Color.Black) }
                )
                OutlinedTextField(
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Senha",
                                tint = Color(0xFFFEE101)
                            )
                        }
                    },
                    value = senha.value,
                    onValueChange = { senha.value = it},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.Transparent,
                        focusedBorderColor = Color(0xFFE9CE03),
                        unfocusedBorderColor = Color(0xFFE9CE03)
                    ),
                    label = { Text(text = "Senha", color = Color.Black) }
                )
                OutlinedTextField(
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Telefone",
                                tint = Color(0xFFFEE101)
                            )
                        }
                    },
                    value = telefone.value,
                    onValueChange = { telefone.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.Transparent,
                        focusedBorderColor = Color(0xFFE9CE03),
                        unfocusedBorderColor = Color(0xFFE9CE03)
                    ),
                    label = { Text(text = "Telefone", color = Color.Black) }
                )

                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ou cadastre-se com: ",
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Image(
                        painter = painterResource(id = R.drawable.googleimg),
                        contentDescription = "Logo do Google",
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Botão "Próx. passo"
                Spacer(modifier = Modifier.height(20.dp))
                Column (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ){

                        Text(
                            text = messageErrorState,
                            color = Color.Red,
                            fontSize = (12.sp)
                        )
                    Button(
                        onClick = {
                            if (nome.value.isEmpty() || email.value.isEmpty() ||
                                senha.value.isEmpty() || telefone.value.isEmpty()) {
                                erroCadastroInfo = true
                                messageErrorState = "O campo não pode estar vazio."
                            } else if (nome.value.length > 90 || email.value.length > 255 ||
                                senha.value.length > 25 || telefone.value.length > 15) {
                                erroCadastroInfo = true
                                messageErrorState = "Os campos não foram preenchidos corretamente."
                            }
                            else if (nome.value.length < 1) {
                                erroCadastroInfo = true
                                messageErrorState = "Os campos preenchidos são curtos demais."
                            } else if (email.value.length < 8 ) {
                                erroCadastroInfo = true
                                messageErrorState = "O campo do email é muito curto"
                            }
                            else if (senha.value.length < 4) {
                                erroCadastroInfo = true
                                messageErrorState = "A senha é curta demais."
                            }
                            else if (telefone.value.length < 8) {
                                erroCadastroInfo = true
                                messageErrorState = "O telefone está preenchido incorretamente."
                            } else {
                                erroCadastroInfo = false
                                etapa2.value = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFFFEE101)),
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Prox. passo", color = Color.Black, letterSpacing = 1.sp)
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                }
            }
        } else if (!etapa3.value) {
            //etapa2
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

                        Row(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(150.dp)
                                .fillMaxWidth()
                        ) {
                            OutlinedTextField(
                                value = dia,
                                onValueChange = {
                                    if (it.text.length <= 2) {
                                        dia = it
                                    }
                                },
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
                                    value = selectedMonth,
                                    onValueChange = { }, // Não é necessário, pois é readOnly
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
                                    meses.forEach { month ->
                                        DropdownMenuItem(
                                            text = { Text(month) },
                                            onClick = {
                                                selectedMonth = month // Atualiza o mês selecionado
                                                expandedMonth = false // Fecha o menu

                                                // Obtém o valor do mês selecionado
                                                monthValue = monthValues[month] ?: ""
                                            }
                                        )
                                    }
                                }
                            }


                            OutlinedTextField(
                                value = ano,
                                onValueChange = {
                                    if(it.text.length <= 4){
                                        ano = it
                                    }
                                },
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
                            )
                        }
                    }
                }
//                Button(
//                    onClick = {
//                        // Supondo que dia e meses são MutableState<String>
//                        if (dia() || meses() || ano.()) {
//                            erroCadastroInfo = true
//                            messageErrorState = "Não deve haver campos vazios"
//                        } else if (dia.value.length > 2) {
//                            erroCadastroInfo = true
//                            messageErrorState = "Erro ao cadastrar dia"
//                        } else {
//                            etapa3.value = true
//                        }
//                        },
//                    colors = ButtonDefaults.buttonColors(Color(0xFFFEE101)),
//                    modifier = Modifier
//                        .offset(x = 160.dp, y = 60.dp)
//                        .width(180.dp)
//                        .height(40.dp)
//                ) {
//                    Text(
//                        text = "Prox. passo",
//                        color = Color.Black,
//                        letterSpacing = 1.sp
//                    )
//                    Icon(
//                        modifier = Modifier.padding(start = 30.dp),
//                        imageVector = Icons.Filled.ArrowForward,
//                        contentDescription = "",
//                        tint = Color.Black
//                    )
//                }
            }
        } else {
            //etapa3

            // Segundo passo: Seleção de matérias
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Nos diga 2 matérias que queira estudar.",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(60.dp))

                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    Log.d("API_RESPONSE", "Lista de materias: $listaMateria")

                    items(listaMateria) { materia ->
                        val index = listaMateria.indexOf(materia) // Obter o índice da matéria
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            Checkbox(
                                checked = materiasSelecionados.getOrNull(index)
                                    ?: false, // Usa o estado real
                                onCheckedChange = { isChecked ->
                                    if (index >= 0) { // Garante que o índice está dentro dos limites
                                        materiasSelecionados[index] = isChecked // Atualiza o estado
                                    }
                                }
                            )
                            Text(
                                text = materia.nome_materia,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(60.dp))

                Button(
                    onClick = {

                        val selecaoMateria = listaMateria.filterIndexed { index, _ -> materiasSelecionados[index] }
                        val idsMateriasSelecionadas = selecaoMateria.map { it.id }
                        // Obtém os IDs das matérias selecionadas
                        // Exemplo: Você pode usar aluno ou professor para exibir informações específicas
                        if (aluno.value) {

                            val alunoPost = Aluno(
                                nome = nome.value,
                                email = email.value,
                                senha = senha.value,
                                telefone = telefone.value,
                                data_nascimento = "${ano.text}-${monthValue}-${dia.text}",
                                serie = "1",
                                materias = idsMateriasSelecionadas
                            )

//                                    val alunoPost = Aluno(
//                                        nome = "Aluno mobile",
//                                        email = "aluno1@example.com",
//                                        senha = "senha1",
//                                        telefone = "11987654321",
//                                        data_nascimento = "15-03-2003",
//                                        serie = "1",
//                                        materias = listOf(1, 2)
//                                    )

                            val call = RetrofitFactory().getAlunoService().postAluno(alunoPost)

                            call.enqueue(object : Callback<Aluno> {
                                override fun onResponse(call: Call<Aluno>, response: Response<Aluno>) {
                                    if (response.isSuccessful) {
                                        val alunoCriado = response.body()
                                        println("Aluno criado com sucesso:")
                                    } else {
                                        println("Erro ao criar aluno: ${response.code()}")
                                    }
                                }

                                override fun onFailure(call: Call<Aluno>, t: Throwable) {
                                    println("Erro: ${t.message}")
                                }
                            })
                            //enviar aluno
//                                    val enviarAluno = RetrofitFactory().getAlunosService().postAluno(
//                                        aluno = Aluno(
//                                            id = id.value,
//                                            nome = nome.value,
//                                            email = email.value,
//                                            senha = senha.value,
//                                            telefone = telefone.value
//                                        )
//                                    )
                        } else if (professor.value) {
                            println("Você é um professor")
                            // Mostrar campos ou mensagens para professor
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFFFEE101)),
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Cadastrar", color = Color.Black, letterSpacing = 1.sp)
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaCadastro1Preview() {
    TelaCadastro1(controleDeNavegacao = null, backStackEntry = null)
}