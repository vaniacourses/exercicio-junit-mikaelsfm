package jokenpo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Jokenpo")
public class JokenpoTest {

    private Jokenpo jogo;

    @BeforeEach
    public void setUp() {
        jogo = new Jokenpo();
    }

    @Test
    @DisplayName("Teste de empate")
    public void testEmpate() {
        assertEquals(0, jogo.jogar(1, 1)); // papel vs papel
        assertEquals(0, jogo.jogar(2, 2)); // pedra vs pedra
        assertEquals(0, jogo.jogar(3, 3)); // tesoura vs tesoura
    }

    @Test
    @DisplayName("Teste vitórias do jogador 1")
    public void testVitoriaJogador1() {
        assertEquals(1, jogo.jogar(1, 2)); // papel vence pedra
        assertEquals(1, jogo.jogar(2, 3)); // pedra vence tesoura
        assertEquals(1, jogo.jogar(3, 1)); // tesoura vence papel
    }

    @Test
    @DisplayName("Teste vitórias do jogador 2")
    public void testVitoriaJogador2() {
        assertEquals(2, jogo.jogar(2, 1)); // pedra perde para papel
        assertEquals(2, jogo.jogar(3, 2)); // tesoura perde para pedra
        assertEquals(2, jogo.jogar(1, 3)); // papel perde para tesoura
    }

    @Test
    @DisplayName("Teste opções inválidas")
    public void testOpcoesInvalidas() {
        assertEquals(-1, jogo.jogar(0, 2)); // jogador 1 inválido
        assertEquals(-1, jogo.jogar(1, 4)); // jogador 2 inválido
        assertEquals(-1, jogo.jogar(-1, 5)); // ambos inválidos
    }
}
