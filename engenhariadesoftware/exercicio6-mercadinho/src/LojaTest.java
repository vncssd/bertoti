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
    void lerTamanhoLista(){
        Loja loja = new Loja();

        Produto produto1 = new Produto("Computador Dell", 3999.90);
        Produto produto2 = new Produto("Suco Maguary Morango 300ml", 9.90);
        loja.adicionarProduto(produto1);
        loja.adicionarProduto(produto2);

        assertEquals(2,loja.lerTamanhoLista());

    }
}