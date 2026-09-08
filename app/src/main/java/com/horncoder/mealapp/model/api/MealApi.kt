package com.horncoder.mealapp.model.api

import com.horncoder.mealapp.model.response.MealCategoriesResponse
import retrofit2.http.GET

interface MealApi {
    @GET("categories.php")
    suspend fun getMeals(): MealCategoriesResponse
}