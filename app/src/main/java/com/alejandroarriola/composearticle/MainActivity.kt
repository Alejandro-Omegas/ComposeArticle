package com.alejandroarriola.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alejandroarriola.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Articulo(titulo = stringResource(R.string.titulo),
                        parrafo1 = stringResource(R.string.parrafo_uno),
                        parrafo2 = stringResource(R.string.parrafo_do)
                    )
                }
            }
        }
    }
}

@Composable
fun Articulo(titulo: String, parrafo1: String, parrafo2: String, modifier: Modifier = Modifier) {
    // Create a box to overlap image and texts
    Column(modifier) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            //alpha = 0.5F
        )

        Text(
            text = titulo,
            fontSize = 24.sp,
            modifier = Modifier
                //.fillMaxSize()
                .padding(16.dp, 16.dp, 16.dp, 16.dp)
        )

        Text(
            text = parrafo1,
            //fontSize = TextStyle.Default, //arroja error
            textAlign = TextAlign.Justify,
            modifier = Modifier
                //.fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
        )

        Text(
            text = parrafo2,
            //fontSize = TextStyle.Default, //arroja error
            textAlign = TextAlign.Justify,
            modifier = Modifier
                //.fillMaxSize()
                .padding(16.dp, 16.dp, 16.dp, 16.dp)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        Articulo(titulo = stringResource(R.string.titulo),
            parrafo1 = stringResource(R.string.parrafo_uno),
            parrafo2 = stringResource(R.string.parrafo_do)
        )
    }
}