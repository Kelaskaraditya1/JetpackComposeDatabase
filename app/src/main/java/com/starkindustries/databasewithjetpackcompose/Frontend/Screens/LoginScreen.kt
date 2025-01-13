package com.starkindustries.databasewithjetpackcompose.Frontend.Screens

import android.content.Context
import android.widget.Space
import android.widget.Toast
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.starkindustries.databasewithjetpackcompose.Database.Database
import com.starkindustries.databasewithjetpackcompose.Frontend.Routes.Routes
import com.starkindustries.databasewithjetpackcompose.Keys.Keys
import com.starkindustries.databasewithjetpackcompose.R

@Composable
fun LoginScreen(navController: NavController){

    var context = LocalContext.current.applicationContext
    var sharedPreferences = context.getSharedPreferences(Keys.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()
    var rememberPassword by remember{
        mutableStateOf(false)
    }

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
                .padding(top = 30.dp)
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
                , visualTransformation = if(rememberPassword) VisualTransformation.None else PasswordVisualTransformation()
            , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            , trailingIcon ={
                IconButton(onClick = {
                    rememberPassword=!rememberPassword
                }) {
                    Icon(painter = 
                        if(rememberPassword)
                            painterResource(id = R.drawable.visibility_on_two)
                        else
                            painterResource(id = R.drawable.visibility_off)
                    , contentDescription = "")
                }
                })

            Spacer(modifier = Modifier
                .height(40.dp))

            Button(onClick = {
                var database = Database(context,Keys.DATABASE_NAME,Keys.VERSION)
                database.getCount()
                if(database.login(username,password)){
                    editor.putBoolean(Keys.LOGIN_STATUS,true)
                    editor.putString(Keys.USERNAME,username)
                    editor.putString(Keys.USERNAME,username)
                    editor.apply()
                    navController.navigate(Routes.DashboardScreen.route)
                }
                else
                    Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()

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
                    navController.navigate(Routes.SignupScreen.route)
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