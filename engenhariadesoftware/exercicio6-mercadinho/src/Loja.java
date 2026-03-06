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


    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public void removerProduto(int index){
        if (produtos.get(index).equals(null)){
            System.out.println("PRODUTO NÃO ENCONTRADO");
        }
        else{
            produtos.remove(index);
        }
    }

    public int lerQuantidadeProdutos(){
        return produtos.size();
    }



}
