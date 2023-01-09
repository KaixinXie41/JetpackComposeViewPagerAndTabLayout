package com.example.jetpackcomposewithviewpageandtablayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewithviewpageandtablayout.ui.theme.JetpackComposeWithViewPageAndTabLayoutTheme

//Navigation Drawer
sealed class DrawerScreens(val title: String, val route:String){
    object Account: DrawerScreens("Account", "home")
    object Payment: DrawerScreens("Payment","account")
    object Support: DrawerScreens("Support","support")
}

private val screens = listOf(
    DrawerScreens.Account,
    DrawerScreens.Payment,
    DrawerScreens.Support
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked:(route:String) ->Unit
){
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ){
        Image(painter = painterResource(id = R.drawable.ic_baseline_smartphone_24),
            contentDescription = "phone icon")
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(

                text = screen.title,
                style = MaterialTheme.typography.h4,
                color = Color.White,
            )
        }
    }
}
