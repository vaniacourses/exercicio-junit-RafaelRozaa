package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTestGPT {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Produto 1", 10.0);
        produto2 = new Produto("Produto 2", 20.0);
    }

    @Test
    void testAddItem() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void testRemoveItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produto1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void testRemoveItemThrowsException() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produto1);
        });
    }

    @Test
    void testGetValorTotal() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(30.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void testEsvazia() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
    }
}