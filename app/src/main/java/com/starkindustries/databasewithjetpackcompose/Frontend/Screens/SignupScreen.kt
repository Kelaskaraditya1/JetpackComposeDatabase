package com.starkindustries.databasewithjetpackcompose.Frontend.Screens

import android.content.Context
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.starkindustries.databasewithjetpackcompose.Database.Database
import com.starkindustries.databasewithjetpackcompose.Frontend.Routes.Routes
import com.starkindustries.databasewithjetpackcompose.Keys.Keys
import com.starkindustries.databasewithjetpackcompose.Model.Student

@Composable
fun SignupScreen(navController: NavController){

    var context = LocalContext.current.applicationContext
    var sharedPreferences = context.getSharedPreferences(Keys.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var studentId by rememberSaveable {
        mutableStateOf("")
    }

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var department by rememberSaveable {
        mutableStateOf("")
    }

    var username by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()){
        Text(text = "Signup Screen"
            , fontSize = 25.sp
            , modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
            , textAlign = TextAlign.Center)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            , verticalArrangement = Arrangement.Center) {

            TextField(value = studentId
                , onValueChange = {
                    studentId=it
                }
                , label = {
                    Text(text = "Student Id"
                        , fontSize = 18.sp
                        , fontWeight = FontWeight.W500)
                }
                , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp))

            Spacer(modifier = Modifier
                .height(10.dp))


            TextField(value = name
                , onValueChange = {
                    name=it
                }
                , label = {
                    Text(text = "Name"
                        , fontSize = 18.sp
                        , fontWeight = FontWeight.W500)
                }
                , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp))

            Spacer(modifier = Modifier
                .height(10.dp))


            TextField(value = department
                , onValueChange = {
                    department=it
                }
                , label = {
                    Text(text = "Department"
                        , fontSize = 18.sp
                        , fontWeight = FontWeight.W500)
                }
                , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp))

            Spacer(modifier = Modifier
                .height(10.dp))

            TextField(value = email
                , onValueChange = {
                    email=it
                }
                , label = {
                    Text(text = "Email"
                        , fontSize = 18.sp
                        , fontWeight = FontWeight.W500)
                }
                , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp))

            Spacer(modifier = Modifier
                .height(10.dp))

            TextField(value = username
                , onValueChange = {
                    username=it
                }
                , label = {
                    Text(text = "Username"
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
                    Text(text = "Password"
                        , fontSize = 18.sp
                        , fontWeight = FontWeight.W500)
                }
                , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp))

            Spacer(modifier = Modifier
                .height(40.dp))

            Button(onClick = {
                var student = Student(studentId,name,username,email,department,password)
                var database = Database(context,Keys.DATABASE_NAME,Keys.VERSION)
                database.getCount()
                if(database.insertData(student)==1){
                    editor.putBoolean(Keys.LOGIN_STATUS,true)
                    editor.commit()
                    editor.apply()
                    navController.navigate(Routes.DashboardScreen.route)
                }
            }
                , shape = RectangleShape
                , modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)) {
                Text(text = "Sign-up"
                    , fontSize = 18.sp
                    , fontWeight = FontWeight.W400)
            }

            Spacer(modifier = Modifier
                .height(100.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Routes.LoginScreen.route)
                }
                , verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement = Arrangement.Center) {
                Text(text = "Already have an account, "
                    , fontSize = 18.sp)
                Text(text = "Login"
                    , fontSize = 18.sp
                    , fontWeight = FontWeight.W500)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SignupPreview(){

    SignupScreen(rememberNavController())

}