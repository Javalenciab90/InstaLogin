package com.example.instalogin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.instalogin.ui.theme.InstaLoginTheme
import com.example.instalogin.ui.twiter.TwitDivider
import com.example.instalogin.ui.twiter.TwitterCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaLoginTheme {
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
                 */
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(Color(0xFF161D26))
                ) {
                    TwitterCard()
                    TwitDivider()
                }
            }
        }
    }
}