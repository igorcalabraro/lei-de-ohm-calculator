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
    val v = r * i
    println("Resultado: Tensão (V) = %.2f V".format(v))
}

// Calcula a Resistência (R = V / I)
fun calcularResistencia() {
    println("\nCalculando Resistência (R = V / I)")
    val v = obterEntradaNumerica("Digite a Tensão (V) em Volts: ")
    val i = obterEntradaNumerica("Digite a Corrente (I) em Amperes:")

    if (i == 0.0) {
        println("Erro: Corrente não pode ser zero para este cálculo.")
    } else {
        val r = v / i
        println("Resultado: Resistência (R) = %.2f Ohms (Ω)".format(r))
    }
}

// Calcula a Corrente (I = V / R)
fun calcularCorrente() {
    println("\nCalculando Corrente (I = V / R)")
    val v = obterEntradaNumerica("Digite a Tensão (V) em Volts: ")
    val r = obterEntradaNumerica("Digite a Resistência (R) em Ohms: ")

    if (r == 0.0) {
        println("Erro: Resistência não pode ser zero para este cálculo.")
    } else {
        val i = v / r
        println("Resultado: Corrente (A) = %.2f A".format(i))
    }
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