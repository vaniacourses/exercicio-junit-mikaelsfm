package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Produto 1", 100.0);
        produto2 = new Produto("Produto 2", 200.0);
    }

    @Test
    public void testAdicionarItem() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testGetValorTotal() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(300.0, carrinho.getValorTotal());
    }

    @Test
    public void testRemoverItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produto1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void testRemoverItemInexistenteLancaExcecao() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produto1);
        });
    }

    @Test
    public void testEsvaziarCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }
}