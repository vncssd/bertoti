import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

class LojaTest {

    @Test
    void adicionarProduto() {

        Loja loja = new Loja();

        Produto produto = new Produto("Suco Maguary Morango 300ml", 9.90);
        loja.adicionarProduto(produto);

        assertEquals(1,loja.getProdutos().size());

    }
}