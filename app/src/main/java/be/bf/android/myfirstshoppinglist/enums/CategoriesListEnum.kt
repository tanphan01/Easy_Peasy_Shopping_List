package be.bf.android.myfirstshoppinglist.enums

import be.bf.android.myfirstshoppinglist.R

enum class CategoriesEnum(val src: Int, val txt : String) {
    PETS(R.drawable.cat_animals2, "Pets"),
    SKINCARE(R.drawable.cat_skincare, "Skin Care"),
    BABY_CARE(R.drawable.cat_baby, "Baby Care"),
    FROZEN_FOODS(R.drawable.cat_frozen, "Frozen Foods"),
    HOUSEHOLD(R.drawable.cat_household, "Household"),
    HEALTHCARE(R.drawable.cat_healthcare, "Healthcare"),
    BAKERY_BREAD(R.drawable.cat_bread, "Bakery & Bread"),
    OILS_SAUCES_CONDIMENTS(R.drawable.cat_condiments, "Oils, Sauces & Condiments"),
    DRINKS(R.drawable.cat_drinks, "Drinks"),
    DAIRY_CHEESE_EGGS(R.drawable.cat_milk, "Dairy, Cheese & Eggs")
}