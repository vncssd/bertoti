package service;

import io.github.ollama4j.Ollama;
import model.RoteiroModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RoteiroService {

    private OllamaService ollamaService = new OllamaService();

    public RoteiroModel gerarRoteiro(String genero, String meioComunicacao, String descricao){

        RoteiroModel roteiro = new RoteiroModel(genero, meioComunicacao, descricao);
        roteiro.setTitulo(ollamaService.createUserQuestion("(Responda APENAS com o título, sem explicações, sem pontuação extra, sem aspas) " +
                "Crie um ítulo para esse roteiro, seja fiel ao genero: " + roteiro.getGenero() +
                "meio de comunicação: " + roteiro.getMeioComunicacao() +
                "e descrição do roteiro: " + roteiro.getDescricao()));

        String prompt = "Crie um roteiro curto (máximo de 1500 palavras) de " + roteiro.getGenero() +
                "com o título: " + roteiro.getTitulo() +
                " para " + roteiro.getMeioComunicacao() +
                "A história é a seguinte: " + roteiro.getDescricao() +
                ". O roteiro deve conter:lista de no máximo 3 personagens com descrição em 1 frase," +
                " e no máximo 5 cenas numeradas com locação, ação e diálogos. O tom e a linguagem devem ser totalmente fiéis ao gênero " + roteiro.getGenero() + ".";

        roteiro.setTexto(ollamaService.createUserQuestion(prompt));

        return roteiro;
    }

    public void gerarDocumentoRoteiro(RoteiroModel roteiro){
        String documentosCaminho = System.getProperty("user.home") + "/Documentos/roteiro.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(documentosCaminho))) {
            bw.write("Título: " + roteiro.getTitulo());
            bw.newLine(); // quebra de linha multiplataforma
            bw.write("Gênero: " + roteiro.getGenero());
            bw.newLine();
            bw.write("Meio de comunicação: " + roteiro.getMeioComunicacao());
            bw.newLine();
            bw.write(roteiro.getTexto());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
