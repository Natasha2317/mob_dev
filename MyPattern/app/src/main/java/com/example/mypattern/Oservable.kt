package com.example.mypattern

// OBSERVABLE
// это поведенческий паттерн проектирования, который создаёт механизм подписки, позволяющий одним объектам следить
// и реагировать на события, происходящие в других объектах.


interface IObserver {   // Метод будет выполняться каждый раз, когда в наблюдаемом нами объекте происходит изменение
    fun update()
}

interface IObservable {   // Отвечает за хранение информации обо всех наблюдателях и отправку им событий обновления
    val observers: ArrayList<IObserver>

    fun add(observer: IObserver) {   // отслеживаем наблюдателей
        observers.add(observer)
    }

    fun sendUpdateEvent() {   // отправляем события обновления всем наблюдателям
        observers.forEach { it.update() }
    }
}

class Newsletter : IObservable {   // хранит информацию о последней статье
    override val observers: ArrayList<IObserver> = ArrayList()  // наблюдатели в виде списка экземпляров
    var newestArticleUrl = ""   // URL-адрес последней статьи в виде строки
        set(value) {
            field = value
            sendUpdateEvent()  // запускается при появлении новой статьи
        }
}

class Reader(private var newsletter: Newsletter) : IObserver {
    override fun update() {
        println("Новая статья: ${newsletter.newestArticleUrl}")  // выводим url новой статьи в консоль
    }
}