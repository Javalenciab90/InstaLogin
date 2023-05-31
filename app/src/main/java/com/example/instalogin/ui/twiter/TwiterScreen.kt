package com.example.instalogin.ui.twiter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalogin.R

@Composable
fun TwitterCard() {
    var chat by remember { mutableStateOf(false) }
    var like by remember { mutableStateOf(false) }
    var rt by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CircularImage()
        Column(
            modifier = Modifier
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

            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                SocialIcon(
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat),
                            contentDescription = ""
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    isSelected = chat,
                    onItemSelected = { chat = !chat },
                    modifier = Modifier.weight(1f)
                )

                SocialIcon(
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = ""
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = Color(0xFF4CAF50)
                        )
                    },
                    isSelected = rt,
                    onItemSelected = { rt = !rt },
                    modifier = Modifier.weight(1f)
                )
                SocialIcon(
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = ""
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "",
                            tint = Color(0xFFF44336)
                        )
                    },
                    isSelected = like,
                    onItemSelected = { like = !like },
                    modifier = Modifier.weight(1f)
                )
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
fun SocialIcon(
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit,
    modifier: Modifier
) {
    val defaultValue = 1
    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(isSelected) selectedIcon() else unselectedIcon()

        Text(
            text = if(isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview
@Composable
fun TwitDivider() {
    Divider(
        color = Color(0xFFA5A5A5),
        modifier = Modifier
            .padding(top = 8.dp)
            .height(0.5.dp)
            .fillMaxWidth()
    )
}