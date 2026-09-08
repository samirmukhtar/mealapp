package com.horncoder.mealapp.ui.meal

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horncoder.mealapp.model.MealRepository
import com.horncoder.mealapp.model.response.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealViewModel(private val repository: MealRepository = MealRepository()): ViewModel() {

    init {

        viewModelScope.launch(Dispatchers.IO) {
            val meal = getMeal()
            mealState.value = meal
        }
    }

    val mealState: MutableState<List<Category>> =  mutableStateOf(emptyList())

    private suspend fun getMeal(): List<Category>{
        return repository.getMeal().categories
    }
}