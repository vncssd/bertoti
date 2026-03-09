import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LojaTest {

    @Test
    void adicionarProduto() {

        Loja loja = new Loja();

        Produto produto = new Produto("Suco Maguary Morango 300ml", 9.90);
        loja.adicionarProduto(produto);

        assertEquals(1,loja.getProdutos().size());

    }
    @Test
    void removerProduto() {

        Loja loja = new Loja();

        Produto produto = new Produto("Computador Dell", 3999.90);
        loja.adicionarProduto(produto);

        loja.removerProduto(0);

        assertEquals(0,loja.getProdutos().size());
    }
    @Test
    void lerQuantidadeProdutos(){
        Loja loja = new Loja();

        Produto produto1 = new Produto("Computador Dell", 3999.90);
        Produto produto2 = new Produto("Suco Maguary Morango 300ml", 9.90);
        loja.adicionarProduto(produto1);
        loja.adicionarProduto(produto2);

        assertEquals(2,loja.lerQuantidadeProdutos());

    }

    @Test
    void encontrarPorNomePreco() {

        Loja loja = new Loja();

        Produto produto1 = new Produto("Computador Dell", 3999.90);
        Produto produto2 = new Produto("Suco Maguary Morango 300ml", 9.90);
        Produto produto1copia1 = new Produto("Computador Dell", 3999.90);

        List<Produto> produtosEncontrados = new LinkedList<>();

        loja.adicionarProduto(produto1);
        loja.adicionarProduto(produto1copia1);
        loja.adicionarProduto(produto2);

        Produto produto1copia2 = new Produto("Computador Dell", 3999.90);
        Produto produto1copia3 = new Produto("Computador Dell", 3999.90);
        Produto produto1copia4 = new Produto("Computador Dell", 3999.90);

        loja.adicionarProduto(produto1copia2);
        loja.adicionarProduto(produto1copia3);
        loja.adicionarProduto(produto1copia4);

        produtosEncontrados = loja.encontrarPorNomePreco(produto1);
        assertEquals(5, produtosEncontrados.size());

    }
}