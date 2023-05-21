package com.example.instalogin.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalogin.R

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable { mutableStateOf(false) }
    
    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        EmailTextField(email) { email = it }
        Spacer(modifier = Modifier.size(8.dp))
        PasswordTextField(password = password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassWordTextView(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
    }
}

@Composable
fun LoginDivider() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier
                .defaultMinSize()
                .background(Color(0xFFF9F9F9))
                .weight(1f)
        )
        Text(
            text = "OR",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5),
            modifier = Modifier.padding(horizontal = 6.dp)
        )
        Divider(
            modifier = Modifier
                .defaultMinSize()
                .background(Color(0xFFF9F9F9))
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(onClick = {  }, enabled = loginEnable, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Log In")
    }
}

@Composable
fun ForgotPassWordTextView(modifier: Modifier) {
    Text(
        text = "Forgot Password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        fontFamily = FontFamily.SansSerif,
        modifier = modifier
    )
}

@Composable
fun PasswordTextField(password: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { text -> onTextChanged(text) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmailTextField(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { text -> onTextChanged(text) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "logo",
        modifier = modifier
    )
}


@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close app",
        modifier = modifier
            .clickable {
                activity.finish()
            }
    )
}