@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.example.text

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        topBar()

        MyCustomText(name = texto)

        OutlinedTextField(
            leadingIcon = { //trailingIcon = icon in the right
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

@Composable
fun topBar(){
    Box(
        Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(Color.Red)
            .systemBarsPadding(),
    ){
        Box(modifier = Modifier
            .align(Alignment.CenterStart)
            .padding(5.dp)){
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home icon")
        }
        Box(modifier = Modifier.align(Alignment.Center)){
            Text(text = "Bom dia", textAlign = TextAlign.Center,fontWeight = FontWeight.Bold,fontSize = 25.sp)
        }
    }
}

@Composable
fun MyCustomText(name: String) {
    val pattern = remember {
        Regex("[a-zA-z\\s]*")}
    val context = LocalContext.current
    var nome = ""
    if(name.matches(pattern)){
        nome = name
    } else {
        Toast.makeText(context, "Não use Números", Toast.LENGTH_SHORT).show()
    }
    Text(text = "Meu nome é $nome", Modifier.padding(8.dp))
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMyApp() {
    TextTheme {
        MyApp()
    }
}
