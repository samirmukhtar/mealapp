package com.horncoder.mealapp.model.api

import com.horncoder.mealapp.model.response.MealCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealWebServices {
    private var api: MealApi
    val baseUrl = "https://www.themealdb.com/api/json/v1/1/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealApi::class.java)
    }

    suspend fun getMeal(): MealCategoriesResponse{
        return api.getMeals()
    }
}