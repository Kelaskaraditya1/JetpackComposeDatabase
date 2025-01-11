package com.starkindustries.databasewithjetpackcompose.Frontend.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.starkindustries.databasewithjetpackcompose.Frontend.Routes.Routes

@Composable
fun DashboardScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
    , contentAlignment = Alignment.Center){
        Button(onClick = {
            navController.navigate(Routes.LoginScreen.route)
        }
        , shape = RectangleShape) {
            Text(text = "Logout"
            , fontSize = 18.sp
            , fontWeight = FontWeight.W500)
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DashboardPreview(){
    DashboardScreen(rememberNavController())
}