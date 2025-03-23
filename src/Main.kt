@file:JvmName("JDoodle")
fun main() {
    // Loop principal do programa que exibe o menu e executa a opção escolhida pelo usuário
    while (true) {
        when (exibirMenu()) {
            1 -> calcularTensao() // Calcula a tensão
            2 -> calcularCorrente() // Calcula a corrente
            3 -> calcularResistencia() // Calcula a resistência
            4 -> {
                exibirMensagemSaida() // Exibe a mensagem de saída e encerra o programa
                break
            }
            else -> println("Opção inválida! Tente novamente.") // Mensagem para opção inválida
        }
    }
}

// Exibe o menu e retorna a opção escolhida pelo usuário
fun exibirMenu(): Int {
    val nomeProjeto = "Calculadora da Lei de Ohm"
    println("\n${nomeProjeto}")
    println("Escolha o cálculo:")
    println("1. Tensão (V)")
    println("2. Corrente (I)")
    println("3. Resistência (R)")
    println("4. Sair")

    // Lê a entrada do usuário e converte para Int, retornando -1 se a entrada for inválida
    return readLine()?.toIntOrNull() ?: -1
}

// Calcula a Tensão (V = R * I)
fun calcularTensao() {
    println("\nCalculando Tensão (V = R * I)")
    val r = obterEntradaNumerica("Digite a Resistência (Ω): ") // Obtém a resistência do usuário
    val i = obterEntradaNumerica("Digite a Corrente (A): ") // Obtém a corrente do usuário
    val v = calcularTensao(r, i) // Calcula a tensão
    println("Resultado: Tensão (V) = %.2f V".format(v)) // Exibe o resultado formatado
}

// Função que realiza o cálculo da tensão
fun calcularTensao(r: Double, i: Double): Double {
    return r * i
}

// Calcula a Resistência (R = V / I)
fun calcularResistencia() {
    println("\nCalculando Resistência (R = V / I)")
    val v = obterEntradaNumerica("Digite a Tensão (V) em Volts: ") // Obtém a tensão do usuário
    val i = obterEntradaNumerica("Digite a Corrente (I) em Amperes: ") // Obtém a corrente do usuário

    try {
        val r = calcularResistencia(v, i) // Calcula a resistência
        println("Resultado: Resistência (R) = %.2f Ohms (Ω)".format(r)) // Exibe o resultado formatado
    } catch (e: IllegalArgumentException) {
        println("Erro: ${e.message}") // Exibe mensagem de erro se a corrente for zero
    }
}

// Função que realiza o cálculo da resistência
fun calcularResistencia(v: Double, i: Double): Double {
    if (i == 0.0) throw IllegalArgumentException("Corrente não pode ser zero para este cálculo.")
    return v / i
}

// Calcula a Corrente (I = V / R)
fun calcularCorrente() {
    println("\nCalculando Corrente (I = V / R)")
    val v = obterEntradaNumerica("Digite a Tensão (V) em Volts: ") // Obtém a tensão do usuário
    val r = obterEntradaNumerica("Digite a Resistência (R) em Ohms: ") // Obtém a resistência do usuário

    try {
        val i = calcularCorrente(v, r) // Calcula a corrente
        println("Resultado: Corrente (A) = %.2f A".format(i)) // Exibe o resultado formatado
    } catch (e: IllegalArgumentException) {
        println("Erro: ${e.message}") // Exibe mensagem de erro se a resistência for zero
    }
}

// Função que realiza o cálculo da corrente
fun calcularCorrente(v: Double, r: Double): Double {
    if (r == 0.0) throw IllegalArgumentException("Resistência não pode ser zero para este cálculo.")
    return v / r
}

// Obtém uma entrada numérica do usuário, garantindo que seja um número válido
fun obterEntradaNumerica(mensagem: String): Double {
    while (true) {
        print(mensagem)
        val input = readLine()?.toDoubleOrNull()
        if (input != null) return input // Retorna o valor se for um número válido
        println("Entrada inválida! Digite um número válido.") // Mensagem de erro para entrada inválida
    }
}

// Exibe a mensagem de saída
fun exibirMensagemSaida() {
    val nome = "Igor Carvalho Calabraro"
    val ra = "R8651G2"
    println("Programa desenvolvido por $nome, RA $ra encerrado.") // Mensagem de saída com nome e RA do aluno
}