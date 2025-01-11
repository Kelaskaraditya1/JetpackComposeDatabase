package com.starkindustries.databasewithjetpackcompose.Frontend.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.starkindustries.databasewithjetpackcompose.ui.theme.DatabaseWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DatabaseWithJetpackComposeTheme {

            }
        }
    }
}

