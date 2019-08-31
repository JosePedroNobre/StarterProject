package com.josenobre.expensestracker.network.model

data class Expense(
    val id: String,
    val category: ExpenseType,
    val value: String,
    val date: String,
    val expenseGoals: ExpenseGoals
)

data class ExpenseGoals(
    val capValue: String
)

enum class ExpenseType {
    GROCERIES, SHOPPING, FUN, FOOD, TRANSPORT, DEBT, SPORTS, OTHER
}