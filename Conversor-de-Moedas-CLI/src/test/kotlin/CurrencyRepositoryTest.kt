package logic

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CurrencyRepositoryTest {

    private val repository = mockk<ICurrencyRepository>()

    @Test
    fun `deve retornar a cotacao correta quando as moedas sao validas`() = runTest {
        coEvery { repository.getConversionRate("USD", "BRL") } returns 5.45

        val rate = repository.getConversionRate("USD", "BRL")

        assertEquals(5.45, rate)
    }
}