@file:JvmName("JDoodle")

// Constantes globais com nome do projeto e meus dados
const val NOME_PROJETO = "Calculadora da Lei de Ohm"
const val NOME = "Igor Carvalho Calabraro"
const val RA = "R8651G2"

// Função principal que executa o menu interativo até o usuário escolher sair
fun main() {
    while (true) {
        when (exibirMenu()) {
            1 -> calcV() // Opção 1: calcular Tensão
            2 -> calcI() // Opção 2: calcular Corrente
            3 -> calcR() // Opção 3: calcular Resistência
            4 -> {       // Opção 4: sair do programa
                exibirMensagemSaida()
                return // Encerra o programa
            }
            else -> println("Opção inválida! Tente novamente.") // Entrada inválida
        }
    }
}

// Função que exibe o menu de opções e retorna a escolha do usuário
fun exibirMenu(): Int {
    println("\n$NOME_PROJETO")
    println("Escolha o cálculo:")
    println("1. Tensão (V)")
    println("2. Corrente (I)")
    println("3. Resistência (R)")
    println("4. Sair")
    return readLine()?.toIntOrNull() ?: -1 // Retorna -1 se a entrada for inválida
}

// Função para calcular Tensão elétrica (V = R * I)
fun calcV() {
    println("\nCalculando Tensão (V = R * I)")

    // Solicita os valores de R e I com validação
    val r = obterValorPositivo("Digite a Resistência (Ω): ")
    val i = obterValorPositivo("Digite a Corrente (A): ")

    // Calcula e exibe o resultado da Tensão
    val v = r * i
    println("Resultado: Tensão = %.2f V".format(v))
}

// Função para calcular Corrente elétrica (I = V / R)
fun calcI() {
    println("\nCalculando Corrente (I = V / R)")

    val v = obterValorPositivo("Digite a Tensão (V): ")
    var r: Double

    // Garante que a resistência não seja zero (evita divisão por zero)
    do {
        r = obterValorPositivo("Digite a Resistência (Ω): ")
        if (r == 0.0) println("Resistência não pode ser zero.")
    } while (r == 0.0)

    // Calcula e exibe o resultado da Corrente
    val i = v / r
    println("Resultado: Corrente = %.2f A".format(i))
}

// Função para calcular Resistência elétrica (R = V / I)
fun calcR() {
    println("\nCalculando Resistência (R = V / I)")

    val v = obterValorPositivo("Digite a Tensão (V): ")
    var i: Double

    // Garante que a corrente não seja zero (evita divisão por zero)
    do {
        i = obterValorPositivo("Digite a Corrente (A): ")
        if (i == 0.0) println("Corrente não pode ser zero.")
    } while (i == 0.0)

    // Calcula e exibe o resultado da Resistência
    val r = v / i
    println("Resultado: Resistência = %.2f Ω".format(r))
}

// Função que solicita ao usuário um número real positivo (>= 0)
fun obterValorPositivo(mensagem: String): Double {
    while (true) {
        print(mensagem)
        val input = readLine()?.toDoubleOrNull()

        // Retorna o valor se for um número real positivo
        if (input != null && input >= 0) return input

        // Caso contrário, mostra erro e repete a solicitação
        println("Entrada inválida! Digite um número positivo.")
    }
}

// Função que exibe a mensagem de encerramento com nome e RA do desenvolvedor
fun exibirMensagemSaida() {
    println("\nPrograma desenvolvido por $NOME, RA $RA encerrado.")
}
