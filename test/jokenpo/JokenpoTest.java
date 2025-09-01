package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe de teste para o Jokenpo")
public class JokenpoTest {

    private Jokenpo jokenpo;

    @BeforeEach
    public void init() {
        jokenpo = new Jokenpo();
    }

    @Test
    @DisplayName("Deve retornar 0 para empate")
    public void testaEmpate() {
        assertEquals(0, jokenpo.jogar(1, 1));
        assertEquals(0, jokenpo.jogar(2, 2));
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    @Test
    @DisplayName("Deve retornar 1 quando o jogador 1 vence")
    public void testaVitoriaJogador1() {
        assertEquals(1, jokenpo.jogar(1, 2));
        assertEquals(1, jokenpo.jogar(2, 3));
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    @Test
    @DisplayName("Deve retornar 2 quando o jogador 2 vence")
    public void testaVitoriaJogador2() {
        assertEquals(2, jokenpo.jogar(2, 1));
        assertEquals(2, jokenpo.jogar(3, 2));
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    @Test
    @DisplayName("Deve retornar -1 para jogada inválida")
    public void testaJogadaInvalida() {
        assertEquals(-1, jokenpo.jogar(0, 1));
        assertEquals(-1, jokenpo.jogar(1, 4));
        assertEquals(-1, jokenpo.jogar(-1, 2));
    }

}

