package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}

	@Test
    public void testSubtracaoDoisNumeros() {
        int subtracao = calc.subtracao(10, 3);
		assertEquals(7, subtracao);
    }

    @Test
    public void testMultiplicacaoDoisNumeros() {
        int mult = calc.multiplicacao(2, 3);
		assertEquals(6, mult);
    }
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testSomatoria() {
		int n = calc.somatoria(5);
		assertEquals(15, n);
			
	}
	
	@Test
	public void testPositivo() {
		boolean pos = calc.ehPositivo(9);
		assertEquals(true, pos);
				
	}
	
	@Test
	public void testNegativo() {
		boolean pos = calc.ehPositivo(-4);
		assertEquals(false, pos);
				
	}
	
	@Test
	public void testComparaIgual() {
		int value = calc.compara(7, 7);
		assertEquals(0, value);
	}
	
	@Test
	public void testComparaMaior() {
		int value = calc.compara(8, 7);
		assertEquals(1, value);
	}
	
	@Test
	public void testComparaMenor() {
		int value = calc.compara(7, 10);
		assertEquals(-1, value);
	}

}
