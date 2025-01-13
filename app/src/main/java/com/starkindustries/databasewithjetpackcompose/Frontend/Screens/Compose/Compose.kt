package com.starkindustries.databasewithjetpackcompose.Frontend.Screens.Compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DashboardInfo(title:String,value:String){
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        Text(text = "${title} :"
        , fontSize = 18.sp)
        Box(modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)){
            Text(text = "${value}"
            , fontSize = 18.sp
            , modifier = Modifier
                    .padding(10.dp))

        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){
DashboardInfo("Name","Aditya")
}