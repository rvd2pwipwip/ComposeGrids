package com.hdesrosiers.composegrids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hdesrosiers.composegrids.ui.theme.ComposeGridsTheme

//https://alexzh.com/jetpack-compose-building-grids/

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeGridsTheme {
        // A surface container using the 'background' color from the theme
        Column(modifier = Modifier.fillMaxSize()) {
          FixedLazyVerticalGrid()
          AdaptiveLazyVerticalGrid()
          CustomGrid()
        }
      }
    }
  }
}

val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FixedLazyVerticalGrid() {
  LazyVerticalGrid(
    cells = GridCells.Fixed(count = 3),
    contentPadding = PaddingValues(8.dp)
  ) {
    items(data.size) { item ->
      Card(
        modifier = Modifier.padding(4.dp),
        backgroundColor = Color.LightGray
      ) {
        Text(
          text = "Item ${(item + 1).toString()}",
          fontSize = 24.sp,
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(24.dp)
        )
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AdaptiveLazyVerticalGrid() {
  LazyVerticalGrid(
    cells = GridCells.Adaptive(minSize = 160.dp),
    contentPadding = PaddingValues(8.dp)
  ) {
    items(data.size) { item ->
      Card(
        modifier = Modifier.padding(4.dp),
        backgroundColor = Color.LightGray
      ) {
        Text(
          text = "Item ${(item + 1).toString()}",
          fontSize = 24.sp,
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(24.dp)
        )
      }
    }
  }
}

@Composable
fun CustomGrid() {
  val list = (1..10).map { it.toString() }

  LazyColumn {
    itemsIndexed((1..5).map { it.toString() }) { _, row ->
      Text(
        text = "Header",
        modifier = Modifier.padding(start = 30.dp, bottom = 4.dp)
      )
      LazyRow(
        contentPadding = PaddingValues(start = 26.dp, bottom = 10.dp, end = 26.dp)
      ) {
        itemsIndexed(list) { _, column ->
          Card(
            backgroundColor = Color.LightGray,
            modifier = Modifier
              .size(100.dp)
              .padding(4.dp)
          ) {
            Text(
              text = "Row: $row\nCol: $column",
              fontSize = 20.sp,
              textAlign = TextAlign.Center,
              modifier = Modifier.padding(16.dp)
            )
          }
        }
      }
    }
  }

}




























