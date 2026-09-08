package com.horncoder.mealapp.model

import com.horncoder.mealapp.model.api.MealWebServices
import com.horncoder.mealapp.model.response.MealCategoriesResponse


class MealRepository (private val webServices: MealWebServices = MealWebServices()){
    suspend fun getMeal(): MealCategoriesResponse{
        return webServices.getMeal()
    }
}