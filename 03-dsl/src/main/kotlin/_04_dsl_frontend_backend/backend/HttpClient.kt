package _04_dsl_frontend_backend.backend

import _04_dsl_frontend_backend.backend.annotation.BackendApiDsl
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
            }
        )
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }
}

@BackendApiDsl
fun getProducts() = runBlocking {
    client.get("https://bstackdemo.com/api/products").body<Products>()
}

@Serializable
data class Products(val products: List<Product>)

@Serializable
data class Product(
    val id: Int,
    val title: String,
    val availableSizes: List<String>,
    val currencyFormat: String,
    val currencyId: String,
    val description: String,
    val installments: Int,
    val altText: String,
    val isFav: Boolean,
    val price: Int,
    val sku: String
)