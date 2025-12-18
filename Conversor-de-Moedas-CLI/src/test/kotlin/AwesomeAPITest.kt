package logic

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AwesomeAPITest {

    @Test
    fun `deve garantir que a data class armazena os valores corretamente`() {
        val bidValue = "5.45"
        val currency = AwesomeAPI(bid = bidValue, name = "USD/BRL")

        assertEquals(bidValue, currency.bid)
        assertEquals("USD/BRL", currency.name)
    }
}