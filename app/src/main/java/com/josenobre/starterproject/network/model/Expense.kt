package com.josenobre.starterproject.network.model

data class Expense(
    val id: String,
    val category: com.josenobre.starterproject.network.model.ExpenseType,
    val value: String,
    val date: String,
    val expenseGoals: com.josenobre.starterproject.network.model.ExpenseGoals
)

data class ExpenseGoals(
    val capValue: String
)

enum class ExpenseType {
    GROCERIES, SHOPPING, FUN, FOOD, TRANSPORT, DEBT, SPORTS, OTHER
}