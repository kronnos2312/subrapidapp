package org.subrapid.project.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.subrapid.project.model.User
import org.subrapid.project.model.users
import org.subrapid.project.ui.screens.Screen
import subrapidapp.composeapp.resources.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreem(onUserClick: (User) -> Unit ) {
    Screen {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(Strings.app_name) },
                    scrollBehavior = scrollBehavior
                )
            },
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {

            LazyVerticalGrid(
                columns = GridCells.Adaptive(120.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)

            ) {
                items(users, key = { it.id ?: 0 }) { user ->
                    UserItem(user = user, onClick = {
                        onUserClick(it)
                    } )
                }
            }
        }
    }
}

@Composable
fun UserItem(user: User, onClick: (User) -> Unit){
    Column(
        modifier = Modifier.clickable { onClick(user) }
    ) {
        AsyncImage(
            model = user.photo,
            contentDescription = user.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2 / 3f)
                .clip(MaterialTheme.shapes.small)
        )
        /*
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2 / 3f)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        */
        Text(
            text=user.name,
            style= MaterialTheme.typography.bodySmall,
            maxLines=1,
            modifier = Modifier.padding(8.dp)
        )
    }
}