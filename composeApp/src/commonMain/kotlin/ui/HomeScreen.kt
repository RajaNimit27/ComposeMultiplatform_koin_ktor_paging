package ui
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import app.cash.paging.compose.collectAsLazyPagingItems
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

import org.koin.compose.getKoin
import viewmodel.HomeViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = getKoin().get()
    val result by rememberUpdatedState(viewModel.products.collectAsLazyPagingItems())
    Scaffold(
        topBar = {
            TopAppBar(
                contentColor = Color.Black,
                backgroundColor = Color.White,
                title = {
                    Text(
                        "Home",
                        maxLines = 1,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            tint = Color.Black,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
        content = {
            PagingGrid(data = result, content = { ProductCard(it)})
        })

}

