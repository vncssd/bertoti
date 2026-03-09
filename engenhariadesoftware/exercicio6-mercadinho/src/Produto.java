public class Produto {

    private String nome;
    private Double preco;

    public Produto() {
    }

    public Produto(String nome, Double preço) {
        this.nome = nome;
        this.preco = preço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean comparar(Produto produto){
        if (this.nome.equals(produto.nome) && this.preco.equals(produto.preco)){
            return true;
        }
        return false;
    }

}

