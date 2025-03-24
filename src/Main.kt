@file:JvmName("JDoodle")

// Nome do projeto como constante global
const val NOME_PROJETO = "Calculadora da Lei de Ohm"

fun main() {
    while (true) {
        when (exibirMenu()) {
            1 -> calcV() // Calcula a tensão
            2 -> calcI() // Calcula a corrente
            3 -> calcR() // Calcula a resistência
            4 -> {
                exibirMensagemSaida()
                break
            }
            else -> println("Opção inválida! Tente novamente.")
        }
    }
}

// Exibe o menu e retorna a opção escolhida pelo usuário
fun exibirMenu(): Int {
    println("\n$NOME_PROJETO")
    println("Escolha o cálculo:")
    println("1. Tensão (V)")
    println("2. Corrente (I)")
    println("3. Resistência (R)")
    println("4. Sair")

    return readLine()?.toIntOrNull() ?: -1
}

// Calcula a Tensão (V = R * I)
fun calcV() {
    println("\n📌 Calculando Tensão (V = R * I)")
    val r = obterEntradaNumerica("Digite a Resistência (Ω): ")
    val i = obterEntradaNumerica("Digite a Corrente (A): ")
    println("🔹 Resultado: Tensão (V) = %.2f V".format(r * i))
}

// Calcula a Corrente (I = V / R)
fun calcI() {
    println("\n📌 Calculando Corrente (I = V / R)")
    val v = obterEntradaNumerica("Digite a Tensão (V): ")
    val r = obterEntradaNumerica("Digite a Resistência (Ω): ")

    try {
        println("🔹 Resultado: Corrente (A) = %.2f A".format(v / r))
    } catch (e: IllegalArgumentException) {
        println("❌ Erro: Resistência não pode ser zero.")
    }
}

// Calcula a Resistência (R = V / I)
fun calcR() {
    println("\n📌 Calculando Resistência (R = V / I)")
    val v = obterEntradaNumerica("Digite a Tensão (V): ")
    val i = obterEntradaNumerica("Digite a Corrente (A): ")

    try {
        println("🔹 Resultado: Resistência (Ω) = %.2f Ω".format(v / i))
    } catch (e: IllegalArgumentException) {
        println("❌ Erro: Corrente não pode ser zero.")
    }
}

// Obtém entrada numérica válida
fun obterEntradaNumerica(mensagem: String): Double {
    while (true) {
        print(mensagem)
        val input = readLine()?.toDoubleOrNull()
        if (input != null) return input
        println("⚠️ Entrada inválida! Digite um número válido.")
    }
}

// Mensagem de saída padronizada
fun exibirMensagemSaida() {
    val nome = "Igor Carvalho Calabraro"
    val ra = "R8651G2"
    println("\nPrograma desenvolvido por $nome, RA $ra encerrado.")
}
