import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MainKtTest {

    @Test
    fun calcularTensao_validInputs_returnsCorrectResult() {
        val r = 10.0
        val i = 2.0
        val expected = 20.0
        val result = calcularTensao(r, i)
        assertEquals(expected, result)
    }

    @Test
    fun calcularResistencia_validInputs_returnsCorrectResult() {
        val v = 20.0
        val i = 2.0
        val expected = 10.0
        val result = calcularResistencia(v, i)
        assertEquals(expected, result)
    }

    @Test
    fun calcularResistencia_zeroCurrent_throwsException() {
        val v = 20.0
        val i = 0.0
        assertFailsWith<IllegalArgumentException> {
            calcularResistencia(v, i)
        }
    }

    @Test
    fun calcularCorrente_validInputs_returnsCorrectResult() {
        val v = 20.0
        val r = 10.0
        val expected = 2.0
        val result = calcularCorrente(v, r)
        assertEquals(expected, result)
    }

    @Test
    fun calcularCorrente_zeroResistance_throwsException() {
        val v = 20.0
        val r = 0.0
        assertFailsWith<IllegalArgumentException> {
            calcularCorrente(v, r)
        }
    }

    @Test
    fun obterEntradaNumerica_validInput_returnsCorrectResult() {
        val input = "10.0"
        val result = obterEntradaNumerica(input)
        assertEquals(10.0, result)
    }

    @Test
    fun obterEntradaNumerica_invalidInput_throwsException() {
        val input = "invalid"
        assertFailsWith<NumberFormatException> {
            obterEntradaNumerica(input)
        }
    }
}