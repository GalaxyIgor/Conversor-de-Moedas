package logic

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

interface ICurrencyRepository {
    suspend fun getConversionRate(from: String, to: String): Double?
}


class CurrencyRepository : ICurrencyRepository {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getConversionRate(from: String, to: String): Double? {
        return try {
            val url = "https://economia.awesomeapi.com.br/json/last/$from-$to"
            val response: Map<String, AwesomeAPI> = client.get(url).body()

            response.values.first().bid.toDouble()
        } catch (e: Exception) {
            println("Erro na requisição: ${e.message}")
            null
        }
    }

    fun close() = client.close()
}