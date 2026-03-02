import java.util.LinkedList;
import java.util.List;

public class Loja {

    private List<Produto> produtos = new LinkedList<>();

    public Loja() {
    }

    public Loja(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }
}
