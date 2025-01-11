package com.starkindustries.databasewithjetpackcompose.Frontend.Screens

import android.content.Context
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.starkindustries.databasewithjetpackcompose.Frontend.Routes.Routes
import com.starkindustries.databasewithjetpackcompose.Keys.Keys
import com.starkindustries.databasewithjetpackcompose.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController){

    var coroutineScope = rememberCoroutineScope()
    var context = LocalContext.current.applicationContext
    var sharedPreferences = context.getSharedPreferences(Keys.SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()
    LaunchedEffect(key1 = Unit) {
        delay(1000)
        if(sharedPreferences.getBoolean(Keys.LOGIN_STATUS,false))
            navController.navigate(Routes.DashboardScreen.route)
        else
            navController.navigate(Routes.LoginScreen.route)
    }

Box(modifier = Modifier
    .fillMaxSize()
, contentAlignment = Alignment.Center){
    Column {
        Box(contentAlignment = Alignment.Center
            , modifier = Modifier
                .fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.insta_logo)
                , contentDescription = ""
            , modifier = Modifier
                    .size(140.dp))
        }

        Spacer(modifier = Modifier
            .height(100.dp))

        Text(text = "Instagram"
        , modifier = Modifier
                .fillMaxWidth()
        , textAlign = TextAlign.Center
        , fontSize = 25.sp
        , fontWeight = FontWeight.W500)
    }
}

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}