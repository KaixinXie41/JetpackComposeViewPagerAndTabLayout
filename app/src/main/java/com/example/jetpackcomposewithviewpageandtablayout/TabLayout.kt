package com.example.jetpackcomposewithviewpageandtablayout

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun TextLayout(
    tabs: List<TabItem>,
    selectIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    TabRow(selectedTabIndex = selectIndex) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectIndex, onClick = {
                onPageSelected(tabItem)
            }, text = {
                Text(text = tabItem.title)
            })
        }
    }
}

@Composable
fun IconTabLayout(
    tabs: List<TabItem>,
    selectIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    TabRow(selectedTabIndex = selectIndex) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectIndex,
                onClick = {
                    onPageSelected(tabItem)
                }, icon = {
                    Icon(tabItem.icon, "")
                })
        }
    }
}


@Composable
fun ScrollableTabLayout(
    tabs: List<TabItem>,
    selectIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    ScrollableTabRow(selectedTabIndex = selectIndex) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectIndex,
                onClick = {
                    onPageSelected(tabItem)
                }, text = {
                    Text(text = tabItem.title)
                }, icon = {
                    Icon(tabItem.icon, "")
                })
        }

    }
}

@ExperimentalPagerApi
@Composable
fun IconWithTextTabLayout(
    tabs: List<TabItem>,
    selectedIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    TabRow(selectedTabIndex = selectedIndex) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectedIndex, onClick = {
                onPageSelected(tabItem)
            }, text = {
                Text(text = tabItem.title)
            }, icon = {
                Icon(tabItem.icon, "")
            })
        }
    }
}

