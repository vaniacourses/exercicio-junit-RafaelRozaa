package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTestGPT {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    @Test
    void testSoma() {
        assertEquals(5, calc.soma(2, 3));
        assertEquals(0, calc.soma(-2, 2));
        assertEquals(-5, calc.soma(-2, -3));
    }

    @Test
    void testSubtracao() {
        assertEquals(-1, calc.subtracao(2, 3));
        assertEquals(-4, calc.subtracao(-2, 2));
        assertEquals(1, calc.subtracao(-2, -3));
    }

    @Test
    void testMultiplicacao() {
        assertEquals(6, calc.multiplicacao(2, 3));
        assertEquals(-4, calc.multiplicacao(-2, 2));
        assertEquals(6, calc.multiplicacao(-2, -3));
        assertEquals(0, calc.multiplicacao(0, 5));
    }

    @Test
    void testDivisao() {
        assertEquals(2, calc.divisao(6, 3));
        assertEquals(-1, calc.divisao(-3, 3));
        assertEquals(1, calc.divisao(-3, -3));

        // Testa divisão por zero - deve lançar ArithmeticException
        assertThrows(ArithmeticException.class, () -> {
            calc.divisao(5, 0);
        });
    }

    @Test
    void testSomatoria() {
        assertEquals(0, calc.somatoria(0)); // 0
        assertEquals(1, calc.somatoria(1)); // 1 + 0
        assertEquals(6, calc.somatoria(3)); // 3 + 2 + 1 + 0
        assertEquals(55, calc.somatoria(10)); // 10+9+...+0
        assertEquals(0, calc.somatoria(-1)); // Se n negativo, somatória fica 0 (loop não executa)
    }

    @Test
    void testEhPositivo() {
        assertTrue(calc.ehPositivo(0));
        assertTrue(calc.ehPositivo(5));
        assertFalse(calc.ehPositivo(-1));
    }

    @Test
    void testCompara() {
        assertEquals(0, calc.compara(5, 5));
        assertEquals(1, calc.compara(10, 5));
        assertEquals(-1, calc.compara(2, 5));
    }
}

