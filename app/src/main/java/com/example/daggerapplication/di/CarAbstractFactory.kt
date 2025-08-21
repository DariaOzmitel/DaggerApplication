package com.example.daggerapplication.di

private data class Car(val brand: String, val model: String)
private data class Engine(val type: String)

private interface CarFactory {
    fun createCar(): Car
    fun createEngine(): Engine
}

private class ToyotaFactory : CarFactory {
    override fun createCar() = Car("Toyota", "Camry")
    override fun createEngine() = Engine("Hybrid")
}

private class BMWFactory : CarFactory {
    override fun createCar() = Car("BMW", "X5")
    override fun createEngine() = Engine("V8")
}

fun main() {

    val toyotaFactory = ToyotaFactory()
    val toyotaCar = toyotaFactory.createCar()
    val toyotaEngine = toyotaFactory.createEngine()

    val bmwFactory = BMWFactory()
    val bmwCar = bmwFactory.createCar()
    val bmwEngine = bmwFactory.createEngine()

    println(toyotaCar)
    println(toyotaEngine)

    println(bmwCar)
    println(bmwEngine)
}