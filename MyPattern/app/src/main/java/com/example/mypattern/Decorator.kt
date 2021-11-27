package com.example.mypattern

// DECORATOR
// это структурный паттерн проектирования, который позволяет динамически добавлять объектам новую функциональность, оборачивая их в полезные «обёртки».

abstract class Breakfast {  // интерфейс для объектов, обязанности которых могут быть добавлены к ним динамически
    abstract fun getDescription(): String
}

class Tea : Breakfast() {  // Определяет объект, к которому могут быть прикреплены дополнительные обязанности
    override fun getDescription() = "Black tea"
}

class Coffee : Breakfast() {
    override fun getDescription() = "Raf"
}

abstract class FoodDecorator() : Breakfast() {   // Декоратор поддерживает ссылку на объект Breakfast и определяет интерфейс, соответствующий интерфейсу Breakfast.
    abstract fun addFood(): String
}

class CakeFoodDecorator(private val breakfast: Breakfast) : FoodDecorator() {  // добавляем обязанности к Breakfast
    override fun getDescription() = breakfast.getDescription() + addFood()
    override fun addFood() = " with cake"
}

class BiscuitFoodDecorator(private val breakfast: Breakfast) : FoodDecorator() {  // добавляем обязанности к Breakfast
    override fun getDescription() = breakfast.getDescription() + addFood()
    override fun addFood() = " with biscuit"
}

fun main() {
    val teaWithCake = CakeFoodDecorator(Tea())
    val teaWithCakeDescription = teaWithCake.getDescription()
    println("Breakfast: $teaWithCakeDescription")

    val rafWithBiscuit = BiscuitFoodDecorator(Coffee())
    val rafWithBiscuitDescription = rafWithBiscuit.getDescription()
    println("Breakfast: $rafWithBiscuitDescription")
}