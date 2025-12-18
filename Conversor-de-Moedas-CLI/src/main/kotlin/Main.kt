import logic.CurrencyRepository
import java.util.Scanner

suspend fun main() {
    val repository = CurrencyRepository()
    val scanner = Scanner(System.`in`)
    var continuar = true

    println("=== BEM-VINDO AO CONVERSOR KOTLIN 2.2 ===")

    while (continuar) {
        println("\nEscolha uma opção:")
        println("1. Converter Moeda")
        println("2. Sair")
        print("> ")

        when (scanner.next()) {
            "1" -> {
                print("Moeda de origem (ex: USD): ")
                val from = scanner.next().uppercase()
                print("Moeda de destino (ex: BRL): ")
                val to = scanner.next().uppercase()
                print("Valor: ")
                val amount = scanner.nextDouble()

                val rate = repository.getConversionRate(from, to)

                if (rate != null) {
                    val total = amount * rate
                    println("\n Resultado: $amount $from = %.2f $to".format(total))
                    println("Cotação utilizada: $rate")
                } else {
                    println("\n Não foi possível obter a cotação. Verifique os códigos das moedas.")
                }
            }
            "2" -> {
                continuar = false
                println("Encerrando... Até logo!")
            }
            else -> println("Opção inválida!")
        }
    }
    repository.close()
}