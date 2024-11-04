package com.example.ibarsgenshinfood.di

import com.example.ibarsgenshinfood.data.MenuRepository

object Injection {
    fun provideRepository(): MenuRepository {
        return MenuRepository.getInstance()
    }
}