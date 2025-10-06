package com.example.application1st

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.application1st.ui.theme.Application1stTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(name = "Rigoberto Vega")
                }
            }
        }
@Composable
fun MessageCard(name: String) {
    Text(text = "Hola bienvenido $name!")
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message){
    Row (modifier = Modifier.padding(8.dp)){
    Image(
        painter = painterResource(id = R.drawable.profile_picture),
        "Contact profile picture ",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colorScheme.primary,CircleShape)
    )
        Spacer(modifier = Modifier.width(8.dp))
    Column {
    Text(text = msg.author,
        color = MaterialTheme.colorScheme.secondary,
        style = MaterialTheme.typography.titleSmall)
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 10.dp) {
            Text(
                text = msg.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
    }
}
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(msg = Message(author = "Rigo", body = "Hey tu, bienvenido"))
}

@Preview
@Composable
fun PreviewConversation(){
    Application1stTheme {
        Conversation(messages= SampleData.conversationSample)
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
    items( messages){ message ->
        MessageCard(msg=message)
}
}
}