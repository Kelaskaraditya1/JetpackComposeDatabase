package com.starkindustries.databasewithjetpackcompose.Frontend.Routes

import  com.starkindustries.databasewithjetpackcompose.Keys.Keys
sealed class Routes(var route:String) {

    object SplashScreen:Routes(Keys.SPLASH_SCREEN)
    object LoginScreen:Routes(Keys.LOGIN_SCREEN)
    object SignupScreen:Routes(Keys.SIGNUP_SCREEN)
    object DashboardScreen:Routes(Keys.DASHBOARD_SCREEN)
}