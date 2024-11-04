package com.example.ibarsgenshinfood.data

import com.example.ibarsgenshinfood.model.MenuDataSource
import com.example.ibarsgenshinfood.model.OrderMenu
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class MenuRepository {

    private val orderMenus = mutableListOf<OrderMenu>()

    init {
        if (orderMenus.isEmpty()) {
            MenuDataSource.dummyMenus.forEach {
                orderMenus.add(OrderMenu(it, 0))
            }
        }
    }

    fun getAllMenus(): Flow<List<OrderMenu>> {
        return flowOf(orderMenus)
    }

    fun getOrderMenuById(menuId: Int): OrderMenu {
        return orderMenus.first {
            it.menu.id == menuId
        }
    }

    fun updateOrderMenu(menuId: Int, newCountValue: Int): Flow<Boolean> {
        val index = orderMenus.indexOfFirst { it.menu.id == menuId }
        val result = if (index >= 0) {
            val ordeMenu = orderMenus[index]
            orderMenus[index] =
                ordeMenu.copy(menu = ordeMenu.menu, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderMenus(): Flow<List<OrderMenu>> {
        return getAllMenus()
            .map { orderRewards ->
                orderRewards.filter { orderReward ->
                    orderReward.count != 0
                }
            }
    }

    companion object {
        @Volatile
        private var instance: MenuRepository? = null

        fun getInstance(): MenuRepository =
            instance ?: synchronized(this) {
                MenuRepository().apply {
                    instance = this
                }
            }
    }
}