package com.example.responsivelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.responsivelayout.ui.theme.ResponsiveLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiveLayoutTheme {
                ResponsiveScreen()
            }
        }
    }
}

@Composable
fun ResponsiveScreen() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val boxScope = this
        val isWideScreen = maxWidth > 600.dp

        if (isWideScreen) {
            //Bigger screen
            Row(modifier = Modifier.fillMaxSize()) {
                //Navigation side
                NavigationRail(modifier = Modifier.fillMaxHeight()) {
                    NavigationRailItem(
                        selected = true,
                        onClick = {},
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") }
                    )
                    NavigationRailItem(
                        selected = false,
                        onClick = {},
                        icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                        label = { Text("Settings") }
                    )
                }

                //List side
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Detail Content",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    //Scrollable list
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(20) { index ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                ListItem(
                                    headlineContent = { Text("Item $index") },
                                    supportingContent = { Text("Supporting text") }
                                )
                            }
                        }
                    }
                }
            }
        } else {
            //Phone mode
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 32.dp)
            ) {
                item {
                    Text(
                        text = "Home Page",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {}) {
                        Text(" Button")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                //Scrollable list items
                items(20) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        ListItem(
                            headlineContent = { Text("Item $index") },
                            supportingContent = { Text("Details here") }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ResponsiveScreenPreview() {
    ResponsiveLayoutTheme {
        ResponsiveScreen()
    }
}