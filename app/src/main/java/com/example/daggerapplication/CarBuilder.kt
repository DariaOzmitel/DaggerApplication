package com.example.daggerapplication

private data class Car(
    val brand: String,
    val model: String,
    val engine: String,
    val seats: Int,
    val color: String
) {
    class Builder {
        private var brand: String = ""
        private var model: String = ""
        private var engine: String = ""
        private var seats: Int = 0
        private var color: String = "White"

        fun setBrand(brand: String) = apply { this.brand = brand }
        fun setModel(model: String) = apply { this.model = model }
        fun setEngine(engine: String) = apply { this.engine = engine }
        fun setSeats(seats: Int) = apply { this.seats = seats }
        fun setColor(color: String) = apply { this.color = color }

        fun build(): Car {
            return Car(brand, model, engine, seats, color)
        }
    }
}

fun main() {

    val car = Car.Builder()
        .setBrand("BMW")
        .setModel("X5")
        .setEngine("V8")
        .setSeats(5)
        .setColor("Black")
        .build()

    println(car)
}