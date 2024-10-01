package br.senai.sp.jandira.telainicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.senai.sp.jandira.telainicio.ui.theme.TelaInicioTheme
import br.senai.sp.jandira.telainicio.Screens.TelaInicio
import br.senai.sp.jandira.telainicio.Screens.TelaInicio2
import br.senai.sp.jandira.telainicio.Screens.TelaCadastro1
import br.senai.sp.jandira.telainicio.Screens.TelaCadastro2
import br.senai.sp.jandira.telainicio.Screens.TelaCadastroProf
import br.senai.sp.jandira.telainicio.Screens.TelaLogin


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaInicioTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                // cadastroCat()
                //teste
                val controleDeNavegacao = rememberNavController()

                NavHost(navController = controleDeNavegacao, startDestination = "inicio"){
                    composable(route = "inicio"){
                        TelaInicio(controleDeNavegacao)
                    }

                    composable(route = "login"){
                        TelaLogin(controleDeNavegacao)
                    }

                    composable(route = "inicio2"){
                        TelaInicio2(controleDeNavegacao)
                    }
                    composable(
                        route = "cadastro1/{tipoUsuario}",
                        arguments = listOf(navArgument("tipoUsuario") { type = NavType.StringType })
                    ) { backStackEntry ->
                        // Passando o backStackEntry para a TelaCadastro1
                        TelaCadastro1(controleDeNavegacao, backStackEntry)
                    }

                    composable(route = "cadastro2"){
                        TelaCadastro2(controleDeNavegacao)
                    }
                    composable(route = "cadastroprof"){
                        TelaCadastroProf(controleDeNavegacao)
                    }
                }
            }
        }
    }
}