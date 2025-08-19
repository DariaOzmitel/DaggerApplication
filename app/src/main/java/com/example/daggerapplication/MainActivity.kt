package com.example.daggerapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.daggerapplication.databinding.ActivityMainBinding
import com.example.database.entities.Bouquet
import com.example.database.entities.BouquetFlowerCrossRef
import com.example.database.entities.Flower
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val component by lazy {
        (application as DaggerApp).appComponent
    }
    private val databaseComponent by lazy {
        (application as DaggerApp).provideDatabaseComponent()
    }
    private val flowerDao by lazy {
        databaseComponent.provideFlowerDao()
    }
    private val bouquetDao by lazy {
        databaseComponent.provideBouquetDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        component.inject(this)

        lifecycleScope.launch {
            insertMockData()
            getAvailableBouquets()
            buyBouquet(2)
            getAvailableBouquets()

        }
    }

    private suspend fun buyBouquet(bouquetId: Int) {
        val flowersFromBouquet = bouquetDao.getRemainingFlowersAfterBuyingBouquet(bouquetId)
        flowersFromBouquet.forEach { flowerWithCount ->
            flowerDao.updateQuantity(
                flowerId = flowerWithCount.flowerId,
                newQuantity = flowerWithCount.count
            )
        }
    }

    private suspend fun getAvailableBouquets() {
        val result = bouquetDao.getAvailableBouquets()
        Log.d("MyTag", "Букеты в наличии: $result")
    }

    private suspend fun insertMockData() {
        val mockBouquets = listOf(
            Bouquet(id = 1, name = "Романтический"),
            Bouquet(id = 2, name = "Весенний"),
            Bouquet(id = 3, name = "Королевский")
        )

        val mockFlowers = listOf(
            Flower(id = 1, name = "Роза белая", quantity = 35),
            Flower(id = 2, name = "Роза красная", quantity = 43),
            Flower(id = 3, name = "Тюльпан", quantity = 37),
            Flower(id = 4, name = "Пион", quantity = 35),
            Flower(id = 5, name = "Орхидея", quantity = 38)
        )

        val mockCrossRefs = listOf(
            // Букет 1: 3 белые розы + 2 тюльпана
            BouquetFlowerCrossRef(bouquetId = 1, flowerId = 1, count = 3),
            BouquetFlowerCrossRef(bouquetId = 1, flowerId = 3, count = 2),

            // Букет 2: 10 красных роз
            BouquetFlowerCrossRef(bouquetId = 2, flowerId = 2, count = 10),

            // Букет 3: 5 пионов + 2 орхидеи
            BouquetFlowerCrossRef(bouquetId = 3, flowerId = 4, count = 5),
            BouquetFlowerCrossRef(bouquetId = 3, flowerId = 5, count = 2)
        )
        flowerDao.insertFlowers(mockFlowers)
        bouquetDao.insertBouquet(mockBouquets)
        bouquetDao.insertBouquetFlowers(mockCrossRefs)
    }
}