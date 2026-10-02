package com.example.testnewactivity


import android.content.Intent
import android.os.Bundle
import androidx.compose.material3.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.testnewactivity.ui.theme.TestNewActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestNewActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NewActivityScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NewActivityScreen(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row(
        Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {

                    val intent = Intent(context, MainActivity2::class.java)
                    intent.putExtra("name","Activity 2")
                    context.startActivity(intent)

                }

            ) {
                Text(text = "Launch activity")
            }
        }
    }
}

