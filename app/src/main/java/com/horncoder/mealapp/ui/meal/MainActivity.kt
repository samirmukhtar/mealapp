package com.horncoder.mealapp.ui.meal

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.horncoder.mealapp.model.response.Category
import com.horncoder.mealapp.ui.theme.MealAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MealScreen(
                        name = "Geedi",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MealScreen(name: String, modifier: Modifier = Modifier) {
    val viewModel: MealViewModel = viewModel()
    val rememberedMeal: MutableState<List<Category>> = remember { mutableStateOf(emptyList()) }
    val coroutineScope = rememberCoroutineScope()
//
    LaunchedEffect(key1 = "GET_MEAL") {
        coroutineScope.launch(Dispatchers.IO) {
            val meal = viewModel.getMeal()
            rememberedMeal.value = meal
        }
    }

    LazyColumn {
        items( rememberedMeal.value){meal ->
            Text(
                text = meal.name,
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MealScreenPreview() {
    MealAppTheme {
        MealScreen("Android")
    }
}