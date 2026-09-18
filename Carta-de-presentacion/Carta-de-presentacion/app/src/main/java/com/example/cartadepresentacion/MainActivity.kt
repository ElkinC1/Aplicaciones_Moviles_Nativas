package com.example.cartadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFD2E8D4)
            ) {
                CartaDePresentacion()
            }
        }
    }
}

@Composable
fun CartaDePresentacion() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto_de_elkin),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = "Elkin Cantos",
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Futuro Ingeniero en Software, sabe de python",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF006D3B)
            )
        }

        Column {
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_phone),
                    contentDescription = null,
                )
                Text(text = "  +593 99 019 5933", fontSize = 16.sp)
            }
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_share),
                    contentDescription = null,

                )
                Text(text = "  @ElkinC1", fontSize = 16.sp)
            }
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_email),
                    contentDescription = null,
                )
                Text(text = "  e1317159042@live.uleam.edu.ec", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCartaDePresentacion() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE4F7ED)
    ) {
        CartaDePresentacion()
    }
}