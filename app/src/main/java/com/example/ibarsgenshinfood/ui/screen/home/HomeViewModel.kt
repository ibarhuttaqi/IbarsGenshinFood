package com.example.ibarsgenshinfood.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibarsgenshinfood.data.MenuRepository
import com.example.ibarsgenshinfood.model.OrderMenu
import com.example.ibarsgenshinfood.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MenuRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderMenu>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderMenu>>>
        get() = _uiState

    fun getAllMenus() {
        viewModelScope.launch {
            repository.getAllMenus()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderMenus ->
                    _uiState.value = UiState.Success(orderMenus)
                }
        }
    }
}