fun main() {
    while (true) {
        when (exibirMenu()) {
            1 -> calcularTensao()
            2 -> calcularCorrente()
            3 -> calcularResistencia()
            4 -> {
                exibirMensagemSaida()
                break
            }
            else -> println("Opção inválida! Tente novamente.")
        }
    }
}

// Exibe o menu e retorna a opção escolhida
fun exibirMenu(): Int {
    val nomeProjeto = "Calculadora da Lei de Ohm"
    println("\n${nomeProjeto}")
    println("Escolha o cálculo:")
    println("1. Tensão (V)")
    println("2. Corrente (I)")
    println("3. Resistência (R)")
    println("4. Sair")

    return readLine()?.toIntOrNull() ?: -1
}

// Calcula a Tensão (V = R * I)
fun calcularTensao() {
    println("\nCalculando Tensão (V = R * I)")
    val r = obterEntradaNumerica("Digite a Resistência (Ω): ")
    val i = obterEntradaNumerica("Digite a Corrente (A): ")
    val v = calcularTensao(r, i)
    println("Resultado: Tensão (V) = %.2f V".format(v))
}

fun calcularTensao(r: Double, i: Double): Double {
    return r * i
}

// Calcula a Resistência (R = V / I)
fun calcularResistencia() {
    println("\nCalculando Resistência (R = V / I)")
    val v = obterEntradaNumerica("Digite a Tensão (V) em Volts: ")
    val i = obterEntradaNumerica("Digite a Corrente (I) em Amperes:")

    try {
        val r = calcularResistencia(v, i)
        println("Resultado: Resistência (R) = %.2f Ohms (Ω)".format(r))
    } catch (e: IllegalArgumentException) {
        println("Erro: ${e.message}")
    }
}

fun calcularResistencia(v: Double, i: Double): Double {
    if (i == 0.0) throw IllegalArgumentException("Corrente não pode ser zero para este cálculo.")
    return v / i
}

// Calcula a Corrente (I = V / R)
fun calcularCorrente() {
    println("\nCalculando Corrente (I = V / R)")
    val v = obterEntradaNumerica("Digite a Tensão (V) em Volts: ")
    val r = obterEntradaNumerica("Digite a Resistência (R) em Ohms: ")

    try {
        val i = calcularCorrente(v, r)
        println("Resultado: Corrente (A) = %.2f A".format(i))
    } catch (e: IllegalArgumentException) {
        println("Erro: ${e.message}")
    }
}

fun calcularCorrente(v: Double, r: Double): Double {
    if (r == 0.0) throw IllegalArgumentException("Resistência não pode ser zero para este cálculo.")
    return v / r
}

// Obtém uma entrada numérica do usuário, garantindo que seja um número válido
fun obterEntradaNumerica(mensagem: String): Double {
    while (true) {
        print(mensagem)
        val input = readLine()?.toDoubleOrNull()
        if (input != null) return input
        println("Entrada inválida! Digite um número válido.")
    }
}

// Exibe a mensagem de saída
fun exibirMensagemSaida() {
    val nome = "Igor Carvalho Calabraro"
    val ra = "R8651G2"
    println("Programa desenvolvido por $nome, RA $ra encerrado.")
}