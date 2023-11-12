package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusCardPage()
                }
            }
        }
    }
}

@Composable
fun BusCardPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFBB86FC))
    ) {
            Profile(
                image = painterResource(R.drawable.android_logo),
                name = stringResource(R.string.name_text),
                title = stringResource(R.string.title_text)
            )

            AllContactInfo()
    }
}

@Composable
fun Profile(image: Painter, name: String,  title: String, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 64.dp, top = 120.dp, bottom = 250.dp, end = 64.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(150.dp, 150.dp)
                .padding(bottom = 8.dp)
                .background(Color.Blue)
                .align(alignment = Alignment.CenterHorizontally)
        )

        Text(
            text = name,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF018786),
            textAlign = TextAlign.Center,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContactInfo(icon: Painter, info: String, modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(bottom = 8.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .padding(start = 56.dp)
        )

        Text(
            text = info,
            modifier = Modifier
                .weight(3f)
                .padding(start = 16.dp)
        )
    }
}

@Composable
fun AllContactInfo(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(bottom = 24.dp)
    ) {
            ContactInfo(
                icon = painterResource(R.drawable.baseline_phone_24),
                info = stringResource(R.string.phone_text)
            )

            ContactInfo(
                icon = painterResource(R.drawable.baseline_share_24),
                info = stringResource(R.string.social_handle_text)
            )

            ContactInfo(
                icon = painterResource(R.drawable.baseline_mail_24),
                info = stringResource(R.string.email_text)
            )
        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusCardPage()
    }
}