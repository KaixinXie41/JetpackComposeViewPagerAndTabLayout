package com.example.jetpackcomposewithviewpageandtablayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposewithviewpageandtablayout.ui.theme.JetpackComposeWithViewPageAndTabLayoutTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch
import com.google.accompanist.pager.rememberPagerState as rememberPagerState


@ExperimentalPagerApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeWithViewPageAndTabLayoutTheme {
                TabLayoutDemo()
                AppMainScreen()

            }
        }
    }
}



@ExperimentalPagerApi
@Composable
fun TabLayoutDemo() {
    JetpackComposeWithViewPageAndTabLayoutTheme(
        darkTheme = false,
    ) {
        val pagerState = rememberPagerState()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = {
                TabPage(tabItems = tabs, pagerState = pagerState)
            },
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                Column(content = {
                    TopAppBar(title = { Text("Tab Layout Demo") }
                    )
                    //Replace here with TextTabLayout or ScrollableTabLayout or IconTabLayout
                    IconWithTextTabLayout(
                        tabs,
                        selectedIndex = pagerState.currentPage,
                        onPageSelected = { tabItem: TabItem ->
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(tabItem.index)
                            }
                        })
                })
            },
        )
    }
}

@ExperimentalPagerApi
@Composable
fun AppMainScreen() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Drawer(
                    onDestinationClicked = { route ->
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(route) {
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = DrawerScreens.Account.route
            ) {
                composable(DrawerScreens.Account.route) {
                    Account(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(DrawerScreens.Payment.route) {
                    Payment(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(DrawerScreens.Support.route) {
                    Support(
                        navController = navController
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeWithViewPageAndTabLayoutTheme() {
        AppMainScreen()
    }
}


