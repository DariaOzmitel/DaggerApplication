package com.example.database.di

interface DatabaseComponentProvider {
    fun provideDatabaseComponent(): DatabaseComponent
}