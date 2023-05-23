package com.example.instalogin.ui.twiter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instalogin.R

@Preview
@Composable
fun TwitterCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CircularImage()
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                TextTitle(title = "Aris", Modifier.padding(end = 8.dp))
                TextSecondary(text = "@AristiDevs", Modifier.padding(end = 8.dp))
                TextSecondary(text = "4h", Modifier.padding(end = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "dots",
                    tint = Color.White
                )
            }
            TextBody(
                text = "Este es el body del Twit +" +
                        "Puede ser bastante largo para" +
                        "explicar que todo esta funcionando" +
                        "sin problemas, podemos salir a producción",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {
                SocialIcon()
                SocialIcon()
                SocialIcon()
            }
        }
    }
}

@Composable
fun CircularImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "circular image",
        modifier = Modifier
            .clip(CircleShape)
            .size(55.dp)
    )
}

@Composable
fun TextTitle(title: String, modifier: Modifier) {
    Text(
        text = title,
        color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier
    )
}

@Composable
fun TextSecondary(text: String, modifier: Modifier) {
    Text(
        text = text,
        color = Color.LightGray,
        modifier = modifier
    )
}

@Composable
fun TextBody(text: String, modifier: Modifier) {
    Text(
        text = text,
        color = Color.White,
        modifier = modifier.padding(end = 16.dp)
    )
}

@Composable
fun SocialIcon() {
    IconButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(
            tint = Color(0xFF7E8B98),
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = "comments"
        )
    }
}

@Composable
fun TwitDivider() {
    Divider(
        color = Color(0xFF7E8B98),
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()

    )
}