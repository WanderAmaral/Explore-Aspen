package com.exploreaspen.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.exploreaspen.ui.components.category.CategoryFilterChipView
import kotlinx.serialization.Serializable

@Serializable
data class Category(val id: String, val name: String) {
    @get:DrawableRes
    val icon: Int? get() = CategoryFilterChipView.fromDescription(description = name)?.icon
}
