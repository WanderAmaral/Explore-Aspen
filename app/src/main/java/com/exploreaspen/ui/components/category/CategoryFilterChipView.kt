package com.exploreaspen.ui.components.category

import androidx.annotation.DrawableRes
import com.exploreaspen.R

enum class CategoryFilterChipView(val description: String, @DrawableRes val icon: Int) {
    FAVORITE(description = "Favorite", icon = R.drawable.ic_favorite),
    DOCTOR(description = "Doctor", icon = R.drawable.ic_person),
    PHARMACY(description = "Pharmacy", icon = R.drawable.ic_local_pharmacy),
    SPECIALTIES(description = "Specialties", icon = R.drawable.ic_star_rate),
    RECORD(description = "Record", icon = R.drawable.ic_registration);

    companion object {
        fun fromDescription(description: String): CategoryFilterChipView? {
            return entries.find { it.description == description }
        }
    }
}
