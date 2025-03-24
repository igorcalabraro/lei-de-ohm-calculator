@file:JvmName("JDoodle")

// Nome do projeto armazenado como uma constante global
const val NOME_PROJETO = "Calculadora da Lei de Ohm"

fun main() {
    // Loop principal do programa, que exibe o menu até o usuário escolher sair
    while (true) {
        when (exibirMenu()) {
            1 -> calcV() // Calcula a tensão
            2 -> calcI() // Calcula a corrente
            3 -> calcR() // Calcula a resistência
            4 -> {
                exibirMensagemSaida() // Exibe a mensagem final e encerra o programa
                break
            }
            else -> println("Opção inválida! Tente novamente.") // Mensagem para entradas inválidas
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

    // Lê a entrada do usuário e converte para Int, retornando -1 se a entrada for inválida
    return readLine()?.toIntOrNull() ?: -1
}

// Calcula a Tensão (V = R * I)
fun calcV() {
    println("\nCalculando Tensão (V = R * I)")

    // Obtém os valores necessários do usuário
    val r = obterEntradaNumerica("Digite a Resistência (Ω): ")
    val i = obterEntradaNumerica("Digite a Corrente (A): ")

    // Calcula a tensão e exibe o resultado formatado
    val v = r * i
    println("Resultado: Tensão (V) = %.2f V".format(v))
}

// Calcula a Corrente (I = V / R)
fun calcI() {
    println("\nCalculando Corrente (I = V / R)")

    // Obtém os valores necessários do usuário
    val v = obterEntradaNumerica("Digite a Tensão (V): ")
    val r = obterEntradaNumerica("Digite a Resistência (Ω): ")

    // Verifica se a resistência é zero para evitar erro de divisão
    if (r == 0.0) {
        println("Erro: Resistência não pode ser zero.")
        return
    }

    // Calcula a corrente e exibe o resultado formatado
    val i = v / r
    println("Resultado: Corrente (A) = %.2f A".format(i))
}

// Calcula a Resistência (R = V / I)
fun calcR() {
    println("\nCalculando Resistência (R = V / I)")

    // Obtém os valores necessários do usuário
    val v = obterEntradaNumerica("Digite a Tensão (V): ")
    val i = obterEntradaNumerica("Digite a Corrente (A): ")

    // Verifica se a corrente é zero para evitar erro de divisão
    if (i == 0.0) {
        println("Erro: Corrente não pode ser zero.")
        return
    }

    // Calcula a resistência e exibe o resultado formatado
    val r = v / i
    println("Resultado: Resistência (Ω) = %.2f Ω".format(r))
}

// Obtém uma entrada numérica do usuário, garantindo que seja válida
fun obterEntradaNumerica(mensagem: String): Double {
    while (true) {
        print(mensagem) // Exibe a mensagem para o usuário inserir um valor
        val input = readLine()?.toDoubleOrNull() // Tenta converter a entrada para Double

        // Se a entrada for válida, retorna o valor
        if (input != null) return input

        // Se a entrada for inválida, exibe uma mensagem de erro e solicita novamente
        println("Entrada inválida! Digite um número válido.")
    }
}

// Exibe a mensagem de saída ao usuário
fun exibirMensagemSaida() {
    val nome = "Igor Carvalho Calabraro" // Nome do desenvolvedor
    val ra = "R8651G2" // Registro acadêmico (RA)

    // Exibe a mensagem final informando o encerramento do programa
    println("\nPrograma desenvolvido por $nome, RA $ra encerrado.")
}
