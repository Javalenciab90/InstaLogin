package com.example.instalogin.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier) {
        Divider(
            modifier = Modifier
                .defaultMinSize()
                .background(Color(0xFFF9F9F9))
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(8.dp))
        SignUpTextButton(modifier)
        Spacer(modifier = Modifier.size(8.dp))
    }
}

@Composable
fun SignUpTextButton(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Don't have an account? ",
            color = Color(0xFFB5B5B5)
        )
        Text(
            text = " Sign Up",
            color = Color(0xFF4EA8E9)
        )
    }
}