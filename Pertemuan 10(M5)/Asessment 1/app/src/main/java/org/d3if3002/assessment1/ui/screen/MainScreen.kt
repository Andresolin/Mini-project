package org.d3if3002.assessment1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.d3if3002.assessment1.R
import org.d3if3002.assessment1.ui.theme.Assessment1Theme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = stringResource(id = R.string.logo),
                        modifier = Modifier.size(60.dp)
                    )
                    Text(text = stringResource(id = R.string.app_name), modifier = Modifier.padding(start = 8.dp))
                }
            },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier) {
    var mieAyam by remember { mutableStateOf(0) }
    var mieBakso by remember { mutableStateOf(0) }
    var kerupuk by remember { mutableStateOf(0) }
    var esTeh by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        // Header
        item {
            Text(
                text = stringResource(id = R.string.intro),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Item Card for Mie Ayam
        item {
            ItemCard(
                itemName = stringResource(id = R.string.mie_ayam),
                itemPrice = 10000,
                itemImage = R.drawable.mieayam,
                quantity = mieAyam,
                onQuantityChange = { mieAyam = it }
            )
        }
        item { Divider() }

        // Item Card for Mie Bakso
        item {
            ItemCard(
                itemName = stringResource(id = R.string.mie_bakso),
                itemPrice = 12000,
                itemImage = R.drawable.miebakso,
                quantity = mieBakso,
                onQuantityChange = { mieBakso = it }
            )
        }
        item { Divider() }

        // Item Card for Es Teh
        item {
            ItemCard(
                itemName = stringResource(id = R.string.es_teh),
                itemPrice = 3000,
                itemImage = R.drawable.esteh,
                quantity = esTeh,
                onQuantityChange = { esTeh = it }
            )
        }
        item { Divider() }

        // Item Card for Kerupuk
        item {
            ItemCard(
                itemName = stringResource(id = R.string.kerupukk),
                itemPrice = 2000,
                itemImage = R.drawable.kerupuk,
                quantity = kerupuk,
                onQuantityChange = { kerupuk = it }
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            // Buttons Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                // Tambahkan tombol atau fungsi lain di sini jika diperlukan
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            }
        }
    }
}



@Composable
fun ItemCard(
    itemName: String,
    itemPrice: Int,
    itemImage: Int,
    quantity: Int,
    onQuantityChange: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Image(
            painter = painterResource(id = itemImage),
            contentDescription = itemName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Text(text = itemName, fontSize = 20.sp)
            Text(text = "Rp $itemPrice")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { if (quantity > 0) onQuantityChange(quantity - 1) },
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(8.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "-")
                }

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.width(5.dp))

                Button(
                    onClick = { onQuantityChange(quantity + 1) },
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(8.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "+")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assessment1Theme {
        MainScreen()
    }
}