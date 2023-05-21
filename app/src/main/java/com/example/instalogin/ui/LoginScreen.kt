package com.example.instalogin.ui

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

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

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginButtonEnabled by rememberSaveable { mutableStateOf(false) }
    
    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        EmailTextField(email) {
            email = it
            isLoginButtonEnabled = enabledLogin(email, password)
        }
        Spacer(modifier = Modifier.size(8.dp))
        PasswordTextField(password = password) {
            password = it
            isLoginButtonEnabled = enabledLogin(email, password)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassWordTextView(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginButtonEnabled)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(24.dp))
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Social login fb",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as JAVA90",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
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
    Button(
        onClick = {  },
        enabled = loginEnable,
        colors = ButtonDefaults.buttonColors(
          backgroundColor = Color(0xFF4EA8E9),
          disabledBackgroundColor = Color(0xFF78C8F9),
          contentColor = Color.White,
          disabledContentColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = "Log In")
    }
}

fun enabledLogin(email: String, password: String) : Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
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
    var isPasswordVisible by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { text -> onTextChanged(text) },
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        ),
        trailingIcon = {
            val image =
                if (isPasswordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(imageVector = image, contentDescription = "show password")
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmailTextField(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { text -> onTextChanged(text) },
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
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