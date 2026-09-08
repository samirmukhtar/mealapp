package com.horncoder.mealapp.ui.meal

import androidx.lifecycle.ViewModel
import com.horncoder.mealapp.model.MealRepository
import com.horncoder.mealapp.model.response.Category

class MealViewModel(private val repository: MealRepository = MealRepository()): ViewModel() {
    suspend fun getMeal(): List<Category>{
        return repository.getMeal().categories
    }
}