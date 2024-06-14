package com.example.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                gooday()
            }
        }
    }
}

@Composable
fun gooday(){
    Column(
        Modifier.fillMaxSize().systemBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        topBar()
        asds()
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
        Box(modifier = Modifier.align(Alignment.CenterStart).padding(5.dp)){
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home icon")
        }
        Box(modifier = Modifier.align(Alignment.Center)){
            Text(text = "Bom dia", textAlign = TextAlign.Center,fontWeight = FontWeight.Bold,fontSize = 25.sp)
        }
    }
}

@Composable
fun asds(){
    var texto by remember { mutableStateOf("") }
    val textFieldState = remember { mutableStateOf(TextFieldValue()) }
    Column(
        Modifier.padding(10.dp).fillMaxWidth().systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            value = textFieldState.value,
            onValueChange = { textFieldState.value = it},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                texto = textFieldState.value.text
            }),
            label = { Text("Digite seu nome") }
        )
    }
    Text(text = "Meu nome é $texto")
}

@Preview(showSystemUi = true)
@Composable
fun asd(){
    gooday()
}