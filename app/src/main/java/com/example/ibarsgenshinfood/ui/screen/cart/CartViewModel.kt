package com.example.ibarsgenshinfood.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibarsgenshinfood.data.MenuRepository
import com.example.ibarsgenshinfood.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: MenuRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderMenus() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderMenus()
                .collect { orderMenu ->
                    val totalPrice =
                        orderMenu.sumOf { it.menu.price * it.count }
                    _uiState.value = UiState.Success(CartState(orderMenu, totalPrice))
                }
        }
    }

    fun updateOrderMenu(menuId: Int, count: Int) {
        viewModelScope.launch {
            repository.updateOrderMenu(menuId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderMenus()
                    }
                }
        }
    }
}