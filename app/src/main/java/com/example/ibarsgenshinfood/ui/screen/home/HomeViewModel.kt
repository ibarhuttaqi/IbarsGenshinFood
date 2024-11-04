package com.example.ibarsgenshinfood.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibarsgenshinfood.data.MenuRepository
import com.example.ibarsgenshinfood.model.Menu
import com.example.ibarsgenshinfood.model.OrderMenu
import com.example.ibarsgenshinfood.ui.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MenuRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<OrderMenu>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderMenu>>>
        get() = _uiState

    private val _query = mutableStateOf("")
    val query: State<String>
        get() = _query

//    init {
//        fetchAndGroupMenus()
//    }

    fun fetchAndGroupMenus(query: String = "") {
        viewModelScope.launch {
            repository.searchMenus(query)
                .map { orderMenus -> groupMenus(orderMenus) }
                .catch { exception -> _uiState.value = UiState.Error(exception.message ?: "Unknown Error") }
                .collect { groupedMenus -> _uiState.value = UiState.Success(groupedMenus) }
        }
    }

    private fun groupMenus(orderMenus: List<OrderMenu>): List<OrderMenu> {
        return orderMenus.sortedBy { it.menu.name }
    }

    fun search(query: String) {
        _query.value = query
        fetchAndGroupMenus(query)
    }
}