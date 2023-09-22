package com.angel.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.angel.cuadricula.ui.theme.CuadriculaTheme
import com.angel.cuadricula.model.Topic
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import com.angel.cuadricula.data.DataSource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuadriculaApp()
                }
            }
        }
    }
}

@Composable
fun CuadriculaApp() {
    CuadriculaList(
        topicList = DataSource.loadTopics()
    )
}

@Composable
fun CuadriculaCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Row {
                Box {
                    Image(
                        painter = painterResource(id = topic.imageRes),
                        contentDescription = null,
                        modifier = modifier
                            .size(width = 68.dp, height = 68.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                }
                Column {
                    Text(
                        text = stringResource(id = topic.name),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium), end = dimensionResource(R.dimen.padding_medium), top = dimensionResource(R.dimen.padding_medium), bottom = dimensionResource(R.dimen.padding_small)
                        )
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_grain),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = dimensionResource(R.dimen.padding_medium))
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CuadriculaCardPreview() {
    CuadriculaCard(Topic(R.string.architecture, 58,R.drawable.architecture))
}

@Composable
fun CuadriculaList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(topicList) { topic ->
            CuadriculaCard(
                topic = topic,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}