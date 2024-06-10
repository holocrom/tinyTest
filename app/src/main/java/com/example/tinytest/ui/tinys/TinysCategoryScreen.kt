package com.example.tinytest.ui.tinys

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.tinytest.model.response.Tiny
import com.example.tinytest.ui.theme.TinyTestTheme

@Composable
    fun TinyCategoryScreen() {
        val viewModel : TinyViewModel = viewModel ()
        val tinValue = viewModel.tin.value

        LazyColumn (contentPadding = PaddingValues(16.dp)) {
            items(tinValue){ tinNext ->
                TinyCategory(tinNext)
            }
        }
    }

    @Composable
    fun TinyCategory(tiny:Tiny){
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Card(
            shape = RoundedCornerShape(8),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        ) {
            Row (modifier = Modifier.animateContentSize()) {
                Image(
                    painter = rememberAsyncImagePainter(model = tiny.imageUrl),
                    contentDescription = tiny.description,
                    modifier = Modifier
                        .padding(top = 4.dp, start = 8.dp)
                        .size(88.dp)
                        .align(Alignment.CenterVertically)
                )

                Column (
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth(0.8f)
                        .padding(16.dp),
                ){
                    Text(
                        text = tiny.name,
                        style = MaterialTheme.typography.titleLarge,
                    )
                    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant) {
                        Text(
                            text = tiny.description,
                            maxLines = if(isExpanded) 10 else 4,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Start
                        )
                    }

                }
                Icon(
                    imageVector = if(isExpanded)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand row icon",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(
                            if (isExpanded)
                                Alignment.Bottom
                            else
                                Alignment.CenterVertically
                        )
                        .clickable {
                            isExpanded = !isExpanded

                        }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TinyTestTheme {
            TinyCategoryScreen()
        }

    }