import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LojaTest {

    Loja loja = new Loja();

    Produto produto1 = new Produto("Suco Maguary Morango 300ml", 9.90);
    Produto produto2 = new Produto("Computador Dell", 3999.90);
    Produto produto1copia = new Produto("Computador Dell", 3999.90);
    Produto produto1copia2 = new Produto("Computador Dell", 3999.90);
    Produto produto1copia3 = new Produto("Computador Dell", 3999.90);
    Produto produto1copia4 = new Produto("Computador Dell", 3999.90);

    @Test
    void adicionarProduto() {

        loja.adicionarProduto(produto1);

        assertEquals(1,loja.getProdutos().size());

    }
    @Test
    void removerProduto() {

        loja.adicionarProduto(produto1);

        loja.removerProduto(0);

        assertEquals(0,loja.getProdutos().size());
    }
    @Test
    void lerQuantidadeProdutos(){

        loja.adicionarProduto(produto1);
        loja.adicionarProduto(produto2);

        assertEquals(2,loja.lerQuantidadeProdutos());

    }

    @Test
    void encontrarPorNomePreco() {

        loja.adicionarProduto(produto2);
        loja.adicionarProduto(produto1copia);
        loja.adicionarProduto(produto1copia2);
        loja.adicionarProduto(produto1copia3);
        loja.adicionarProduto(produto1copia4);

        List<Produto> produtosEncontradosTest = loja.encontrarPorNomePreco(produto2);
        assertEquals(5, produtosEncontradosTest.size());

    }
}