package carrinho;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho cart;

    @BeforeEach
    public void init() {
        cart = new Carrinho();
    }

    @DisplayName("Testa retorno do valor total")
    @Test
    public void testaRetornoTotal() {
        Produto p1 = new Produto("Notebook", 3500.00);
        Produto p2 = new Produto("Mouse", 150.00);
        Produto p3 = new Produto("Teclado", 200.00);

        cart.addItem(p1);
        cart.addItem(p2);
        cart.addItem(p3);

        double valorTotal = cart.getValorTotal();

        assertEquals(3850.00, valorTotal);
    }

    @Test
    public void testAddItem() {
        Produto p1 = new Produto("Notebook", 3500.00);
        Produto p2 = new Produto("Mouse", 150.00);

        cart.addItem(p1);
        cart.addItem(p2);

        int cartLen = cart.getQtdeItems();
        assertEquals(2, cartLen);
    }

    @Test
    public void testRemoveItem() {
        Produto p1 = new Produto("Notebook", 3500.00);
        Produto p2 = new Produto("Mouse", 150.00);

        try {
            cart.addItem(p1);
            cart.addItem(p2);
            cart.removeItem(p2);

            int cartLen = cart.getQtdeItems();
            assertEquals(1, cartLen);

        } catch (ProdutoNaoEncontradoException e) {
            fail("Produto não encontrado ao tentar remover item.");
        }
    }

    @Test
    public void testRemoveItemComException() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            Produto p1 = new Produto("Notebook", 3500.00);
            Produto p2 = new Produto("Mouse", 150.00);

            cart.addItem(p1);
            cart.removeItem(p2);
        });
    }

    @Test
    public void testEsvazia() {
        Produto p1 = new Produto("Notebook", 3500.00);
        Produto p2 = new Produto("Mouse", 150.00);
        Produto p3 = new Produto("Teclado", 200.00);

        cart.esvazia();

        int cartLen = cart.getQtdeItems();
        assertEquals(0, cartLen);
    }
}