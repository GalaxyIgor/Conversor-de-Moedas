package logic

import kotlinx.serialization.Serializable

@Serializable
data class AwesomeAPI(
    val bid: String, // Preço de compra
    val name: String, // Nome da moeda
    val create_date: String? = null // Data da cotação
)