package com.starkindustries.databasewithjetpackcompose.Frontend.Screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.starkindustries.databasewithjetpackcompose.Database.Database
import com.starkindustries.databasewithjetpackcompose.Frontend.Routes.Routes
import com.starkindustries.databasewithjetpackcompose.Frontend.Screens.Compose.DashboardInfo
import com.starkindustries.databasewithjetpackcompose.Keys.Keys
import com.starkindustries.databasewithjetpackcompose.Model.Student

@Composable
fun DashboardScreen(navController: NavController){
    
    var context = LocalContext.current.applicationContext
    var sharedPreferences = context.getSharedPreferences(Keys.LOGIN_STATUS, Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()
    var database = Database(context,Keys.DATABASE_NAME,Keys.VERSION)
    var studentId by remember{
        mutableStateOf("")
    }
    var name by remember{
        mutableStateOf("")
    }
    var username by remember{
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var department by remember{
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp, bottom = 20.dp)
    , horizontalAlignment = Alignment.CenterHorizontally) {

        DashboardInfo(title = "Student Id", value = studentId)
        DashboardInfo(title = "Name", value = name)
        DashboardInfo(title = "Username", value = username)
        DashboardInfo(title = "Email", value = email)
        DashboardInfo(title = "Department", value = department)


        Button(onClick = {
            editor.putBoolean(Keys.LOGIN_STATUS,false)
            editor.apply()
            navController.navigate(Routes.LoginScreen.route)
        }
        , shape = RectangleShape
        , modifier = Modifier
                .padding(top = 10.dp)) {
            Text(text = "Logout")
        }

        Button(onClick = {
            database.getCount()
        }
            , shape = RectangleShape
            , modifier = Modifier
                .padding(top = 10.dp)) {
            Text(text = "Get Count")
        }

        Button(onClick = {
           var user =  sharedPreferences.getString(Keys.USERNAME,"kelaskaraditya1")
            var student = database.getSutdentbyUsername(user)
            studentId=student.getStudentId()
            name=student.getName()
            email=student.getEmail()
            department=student.getDepartment()
            username=student.getUsername()
            Log.d("Student",student.toString())
        }
            , shape = RectangleShape
            , modifier = Modifier
                .padding(top = 10.dp)
                .wrapContentSize()) {
            Text(text = "get Student")
        }

        Button(onClick = {
            var student1:Student? = database.getStudent("2021FHCO041")
            student1?.setName("Sandesh Jadhav")
            student1?.setUsername("sandeshjadhav69")
            student1?.setEmail("sandy1@gmail.com")
            student1?.setDepartment("Computer")
            var student = student1?.let { database.updateStudent(student = it,studentId="2021FHCO041") }
            studentId= student?.getStudentId().toString()
            name=student?.getName().toString()
            username=student?.getUsername().toString()
            email=student?.getEmail().toString()
            department=student?.getDepartment().toString()
        }
            , shape = RectangleShape
            , modifier = Modifier
                .padding(top = 10.dp)
                .wrapContentSize()) {
            Text(text = "Update Student")
        }

        Button(onClick = {
            database.deleteStudent("2021FHCO041")
        }
            , shape = RectangleShape
            , modifier = Modifier
                .padding(top = 10.dp)) {
            Text(text = "Delete Student")
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DashboardPreview(){
    DashboardScreen(rememberNavController())
}