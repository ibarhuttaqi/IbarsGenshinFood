package com.example.ibarsgenshinfood.ui.screen.cart

import com.example.ibarsgenshinfood.model.OrderMenu

data class CartState(
    val orderMenu: List<OrderMenu>,
    val totalPrice: Int
)