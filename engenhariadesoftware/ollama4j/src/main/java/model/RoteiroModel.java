package model;

public class RoteiroModel {

    private String titulo;
    private String genero;
    private String meioComunicacao;
    private String descricao;
    private String texto;

    public RoteiroModel() {
    }

    public RoteiroModel(String genero, String meioComunicacao, String descricao) {
        this.genero = genero;
        this.meioComunicacao = meioComunicacao;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMeioComunicacao() {
        return meioComunicacao;
    }

    public void setMeioComunicacao(String meioComunicacao) {
        this.meioComunicacao = meioComunicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
