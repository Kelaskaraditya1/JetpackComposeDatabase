package com.starkindustries.databasewithjetpackcompose.Frontend.Screens

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.starkindustries.databasewithjetpackcompose.Frontend.Routes.Routes

@Composable
fun LoginScreen(navController: NavController){

    var username by rememberSaveable{
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()){
        Text(text = "Login Screen"
        , fontSize = 25.sp
        , modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        , textAlign = TextAlign.Center)
        Column(modifier = Modifier
            .fillMaxSize()
        , verticalArrangement = Arrangement.Center) {
            TextField(value = username
                , onValueChange = {
                    username=it
                }
            , label = {
                Text(text = "username"
                , fontSize = 18.sp
                , fontWeight = FontWeight.W500)
                }
            , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp))

            Spacer(modifier = Modifier
                .height(10.dp))

            TextField(value = password
                , onValueChange = {
                    password=it
                }
            , label = {
                Text(text = "password"
                    , fontSize = 18.sp
                    , fontWeight = FontWeight.W500)
                }
            , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp))

            Spacer(modifier = Modifier
                .height(40.dp))

            Button(onClick = {


            }
            , shape = RectangleShape
            , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)) {
                Text(text = "Login"
                , fontSize = 18.sp
                , fontWeight = FontWeight.W400)
            }

            Spacer(modifier = Modifier
                .height(100.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {

                }
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.Center) {
                Text(text = "Didn't have an account, "
                , fontSize = 18.sp)
                Text(text = "Sign Up"
                , fontSize = 18.sp
                , fontWeight = FontWeight.W500)
            }
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginScreenPreview(){

    LoginScreen(navController = rememberNavController())
}