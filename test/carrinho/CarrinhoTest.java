package carrinho;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste da calculadora")
public class CarrinhoTest {
	
	private Carrinho carr;
	
	@BeforeEach
	public void inicializa() {
		carr = new Carrinho();
		Produto livro = new Produto("livro",10.00);
		Produto filme = new Produto("filme",7.50);
		carr.addItem(livro);
		carr.addItem(filme);
	}
	
	@DisplayName("Testa somatório dos valores de carrinho")
	@Test
	public void testGetValorTotal() {
		assertEquals(17.50, carr.getValorTotal());
	}
	@Test
	public void testRemoveItem() {
		Produto farinha = new Produto("Farinha", 10.00);
		carr.addItem(farinha);
        try {
			carr.removeItem(farinha);
		} catch (ProdutoNaoEncontradoException e) {
			assertThrows(ProdutoNaoEncontradoException.class,() -> carr.removeItem(farinha));
		}
        assertEquals(2, carr.getQtdeItems());
	}
	
    @Test
    void testGetQtdeItems() {
        assertEquals(2, carr.getQtdeItems());
        carr.esvazia();
        assertEquals(0, carr.getQtdeItems());
    }
	
}
