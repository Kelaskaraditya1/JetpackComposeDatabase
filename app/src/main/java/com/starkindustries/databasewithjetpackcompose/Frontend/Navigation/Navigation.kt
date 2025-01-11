package com.starkindustries.databasewithjetpackcompose.Frontend.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.starkindustries.databasewithjetpackcompose.Frontend.Routes.Routes
import com.starkindustries.databasewithjetpackcompose.Frontend.Screens.DashboardScreen
import com.starkindustries.databasewithjetpackcompose.Frontend.Screens.LoginScreen
import com.starkindustries.databasewithjetpackcompose.Frontend.Screens.SignupScreen
import com.starkindustries.databasewithjetpackcompose.Frontend.Screens.SplashScreen

@Composable
fun NavigationCompose(){

    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SplashScreen.route ){
        composable(Routes.SplashScreen.route){
            SplashScreen(navController)
        }

        composable(Routes.LoginScreen.route){
            LoginScreen(navController = navController)
        }

        composable(Routes.SignupScreen.route){
            SignupScreen(navController = navController)
        }

        composable(Routes.DashboardScreen.route){
            DashboardScreen(navController = navController)
        }
    }
}