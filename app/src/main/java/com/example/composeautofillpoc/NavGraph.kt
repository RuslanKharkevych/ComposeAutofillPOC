package com.example.composeautofillpoc

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginView(
                onLoggedIn = { email ->
                    navController.navigate("home/$email") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onSignUp = {
                    navController.navigate("sign-up-email")
                }
            )
        }

        composable("sign-up-email") {
            SignUpEmailView(
                onContinue = { email ->
                    navController.navigate("sign-up-password/$email")
                },
                onLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable("sign-up-password/{email}") { navBackStackEntry ->
            val navArgs = checkNotNull(navBackStackEntry.arguments)
            SignUpPasswordView(
                onSignedUp = {
                    val email = checkNotNull(navArgs.getString("email"))
                    navController.navigate("home/$email") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("home/{email}") { navBackStackEntry ->
            val navArgs = checkNotNull(navBackStackEntry.arguments)
            HomeView(
                email = checkNotNull(navArgs.getString("email")),
                onLogout = {
                    navController.navigate("login") {
                        popUpTo("home/{email}") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}