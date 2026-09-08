package com.horncoder.mealapp.ui.meal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.horncoder.mealapp.model.response.Category
import com.horncoder.mealapp.ui.theme.MealAppTheme

@Composable
fun MealScreen() {
    val viewModel: MealViewModel = viewModel()
    val meal = viewModel.mealState.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meal) { meal ->
            MealCategory(meal)
        }
    }
}

@Composable
fun MealCategory(category: Category) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)

    ) {
        Row() {
            AsyncImage(
                model = category.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(88.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)

            ) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.titleSmall

                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MealScreenPreview() {
    MealAppTheme {
        MealScreen()
    }
}