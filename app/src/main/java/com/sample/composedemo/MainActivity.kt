package com.sample.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.composedemo.ui.theme.ComposeDemoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Column {
                    Spacer(Modifier.height(20.dp))
                    MessageCard(message = Message("Mahmoud", "Hello!"))
                }
            }
        }
    }
}


data class Message(val author: String, val body: String)

@Composable
fun MessageCard(message: Message) {

    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(width = 1.5.dp, color = MaterialTheme.colors.secondary, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.width(4.dp))


            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = Color.Transparent
            ) {

                Text(
                    message.body,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.body2

                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewComposable() {
    ComposeDemoTheme {
        MessageCard(Message("Mahmoud", "Hello World"))
    }
}