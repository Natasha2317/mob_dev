package com.example.mypattern

// FACTORY METHOD
// это порождающий паттерн проектирования, который определяет общий интерфейс для создания объектов в суперклассе, позволяя подклассам изменять тип создаваемых объектов.

interface Person{  // Сначала мы создаем интерфейс Person и два метода, которые представляют действия для людей
    fun getInfo()
    fun age()
}

enum class Gender{  // Затем создаем Gender Enum с двумя экземплярами
    MALE, FEMALE
}

class PersonFactory{  // класс для создания объектов
    companion object{
        fun createPerson(gender: Gender): Person = when (gender){  // метод с Gender в качестве аргумента и реализации метода интерфейса для каждого экземпляра
            Gender.MALE -> object: Person{
                private val name = "Иван"
                override fun getInfo() = println("$name ...")
                override fun age() = println("Возраст $name")
            }
            Gender.FEMALE -> object: Person{
                private val name = "Мария"
                override fun getInfo() = println("$name ...")
                override fun age() = println("Возраст")
            }
        }
    }
}

fun main(args : Array<String>){  // сновной метод, который мы называем из  PersonFactory, и мы можем динамически получить человека, передавая пол в методе

    val person = PersonFactory.createPerson(Gender.MALE)

    println("Информация о человеке: ")
    person.getInfo()
    println("")
    person.age()
}