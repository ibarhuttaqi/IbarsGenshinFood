package com.example.ibarsgenshinfood.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ibarsgenshinfood.R
import com.example.ibarsgenshinfood.di.Injection
import com.example.ibarsgenshinfood.model.OrderMenu
import com.example.ibarsgenshinfood.ui.ViewModelFactory
import com.example.ibarsgenshinfood.ui.common.UiState
import com.example.ibarsgenshinfood.ui.components.MenuItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

//    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.fetchAndGroupMenus()
            }
            is UiState.Success -> {
                val orderMenus = (uiState as UiState.Success<List<OrderMenu>>).data
                HomeContent(
                    orderMenus = orderMenus,
                    query = viewModel.query.value,
                    onQueryChange = viewModel::search,
                    navigateToDetail = navigateToDetail,
                    modifier = modifier,
                )
            }
            is UiState.Error -> {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Error loading menus: ${(uiState as UiState.Error).errorMessage}")
                }
            }
        }
//    }
}

@Composable
fun HomeContent(
    orderMenus: List<OrderMenu>,
    query: String,
    onQueryChange: (String) -> Unit,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
//    Column(
//        modifier = modifier.fillMaxSize()
//    ) {
//        SearchBar(
//            query = query,
//            onQueryChange = onQueryChange,
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primary)
//                .fillMaxWidth()
//        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
//            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.testTag("MenuList")
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                SearchBar(
                    query = query,
                    onQueryChange = onQueryChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                )
            }
//            items(orderMenus) { menu ->
//                MenuItem(
//                    image = menu.menu.image,
//                    name = menu.menu.name,
//                    quality = menu.menu.quality,
//                    price = menu.menu.price,
//                    modifier = Modifier
//                        .clickable {
//                            navigateToDetail(menu.menu.id)
//                        }
//                        .padding(16.dp)
//                )
//            }

            if (orderMenus.isEmpty()) {
                // Display "data not found" message when the list is empty
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(R.string.data_not_found),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                items(orderMenus) { menu ->
                    MenuItem(
                        image = menu.menu.image,
                        name = menu.menu.name,
                        quality = menu.menu.quality,
                        price = menu.menu.price,
                        modifier = Modifier
                            .clickable {
                                navigateToDetail(menu.menu.id)
                            }
                            .padding(16.dp)
                    )
                }
            }
//            }
        }
//    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        placeholder = {
            Text(stringResource(R.string.search_menu))
        },
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {
    }
}
