package com.example.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventStart
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.text.ui.theme.TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var texto by remember {
        mutableStateOf("")
    }
    var novoTexto = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier,
        ) {
            Row(
                modifier = Modifier
                    .background(color = Color.Black)
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                //Icon(, contentDescription = null)
                Text(text = "Bom dia", color = Color.White, textAlign = TextAlign.Center)
            }
        }

        MyCustomText(name = texto)

        OutlinedTextField(
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
                //IconButton(onClick = { texto = novoTexto.value.text }) {}
            },
            value = novoTexto.value,
            onValueChange = { novoTexto.value = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                texto = novoTexto.value.text
            }),
            label = {
                Text("Change name")
            },
        )
    }
}

@Preview
@Composable
fun PreviewMyApp() {
    TextTheme {
        MyApp()
    }
}

@Composable
fun MyCustomText(name: String) {
    val nome = name.ifEmpty { "fulano" }
    Text(text = "Meu nome e $nome", Modifier.padding(8.dp))
}