package com.example.jetpackcomposewithviewpageandtablayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

//TabLayout And ViewPager
sealed class TabItem(
    val index: Int,
    val icon: ImageVector,
    val title: String,
    val screenToLoad: @Composable () -> Unit
) {
    object Home : TabItem(0, Icons.Default.Home, "Home", {
        HomeScreenForTab()
    })

    object ShoppingCart : TabItem(0, Icons.Default.ShoppingCart, "Shop Cart", {
        ShoppingCartScreenForTab()
    })

    object Settings : TabItem(0, Icons.Default.Settings, "Home", {
        SettingsScreenForTab()
    })
}

@Composable
fun SettingsScreenForTab() {
    Column(
        content = {
            Text(
                text = "Home Screen"
            )
        },
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
}

@Composable
fun ShoppingCartScreenForTab() {
    Column(
        content = {
            Text(
                text = "ShoppingCart Screen"
            )
        },
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
}

@Composable
fun HomeScreenForTab() {
    Column(
        content = {
            LazyColumnItemsDemo()
        },
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
}

val tabs = listOf(
    TabItem.Home,
    TabItem.ShoppingCart,
    TabItem.Settings
)

@ExperimentalPagerApi
@Composable
fun TabPage(
    pagerState: PagerState,
    tabItems: List<TabItem>
) {
    HorizontalPager(count = tabs.size, state = pagerState) { index ->
        tabItems[index].screenToLoad()
    }
}
