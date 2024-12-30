package com.exploreaspen.ui.components.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exploreaspen.data.model.Category
import com.exploreaspen.ui.theme.BlueParagrapph
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.Gray300
import com.exploreaspen.ui.theme.Gray400
import com.exploreaspen.ui.theme.Typography

@Composable
fun ExploreAspenCategoryFilterChip(
    modifier: Modifier = Modifier,
    category: Category,
    isSelected: Boolean,
    onClick: (isSelected: Boolean) -> Unit
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .border(
                    width = 0.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(vertical = 2.dp, horizontal = 8.dp)
                .clickable { onClick(!isSelected) }
        ) {
            category.icon?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "Ícone de Filtro de Categoria",
                    modifier = Modifier.size(30.dp),
                    tint =  BlueTitle
                )
            }
            Text(
                text = category.name,
                style = Typography.bodySmall,
                color =  BlueParagrapph,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }

}

@Preview
@Composable
private fun NearbyCategoryFilterChipPreview() {
    ExploreAspenCategoryFilterChip(
        category = Category(id = "1", name = "Favorite"),
        isSelected = true,
        onClick = {},
        )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipNotSelectedPreview() {
    ExploreAspenCategoryFilterChip(
        category = Category(id = "2", name = "Doctor"),
        isSelected = false,
        onClick = {}
    )
}