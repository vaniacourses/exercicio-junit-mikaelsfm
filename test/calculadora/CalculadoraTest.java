package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes da classe Calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculadora();
    }

    @Test
    @DisplayName("Teste soma")
    public void testSoma() {
        assertEquals(5, calc.soma(2, 3));
        assertEquals(0, calc.soma(-2, 2));
        assertEquals(-5, calc.soma(-3, -2));
    }

    @Test
    @DisplayName("Teste subtração")
    public void testSubtracao() {
        assertEquals(1, calc.subtracao(3, 2));
        assertEquals(-4, calc.subtracao(-2, 2));
        assertEquals(0, calc.subtracao(2, 2));
    }

    @Test
    @DisplayName("Teste multiplicação")
    public void testMultiplicacao() {
        assertEquals(6, calc.multiplicacao(2, 3));
        assertEquals(-6, calc.multiplicacao(-2, 3));
        assertEquals(0, calc.multiplicacao(0, 5));
    }

    @Test
    @DisplayName("Teste divisão")
    public void testDivisao() {
        assertEquals(2, calc.divisao(6, 3));
        assertEquals(-2, calc.divisao(-6, 3));
    }

    @Test
    @DisplayName("Teste divisão por zero (espera exceção)")
    public void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0));
    }

    @Test
    @DisplayName("Teste somatória de números positivos")
    public void testSomatoria() {
        assertEquals(15, calc.somatoria(5)); // 0+1+2+3+4+5 = 15
        assertEquals(0, calc.somatoria(0));
    }

    @Test
    @DisplayName("Teste somatória com valor negativo")
    public void testSomatoriaNegativa() {
        assertEquals(0, calc.somatoria(-5)); // deve retornar 0 pois o while não entra
    }

    @Test
    @DisplayName("Teste se número é positivo")
    public void testEhPositivo() {
        assertTrue(calc.ehPositivo(5));
        assertTrue(calc.ehPositivo(0)); // zero é positivo
        assertFalse(calc.ehPositivo(-1));
    }

    @Test
    @DisplayName("Teste comparação")
    public void testCompara() {
        assertEquals(0, calc.compara(3, 3));
        assertEquals(1, calc.compara(5, 3));
        assertEquals(-1, calc.compara(3, 5));
    }
}
