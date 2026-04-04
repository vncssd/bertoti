package service;

import io.github.ollama4j.Ollama;
import io.github.ollama4j.exceptions.OllamaException;
import io.github.ollama4j.models.chat.OllamaChatRequest;
import io.github.ollama4j.models.generate.OllamaGenerateRequest;
import io.github.ollama4j.models.response.OllamaResult;

public class OllamaService {

    private final Ollama OLLAMA = new Ollama("http://localhost:11434");
    private final String MODEL = "gemma3:4b";

    public void pullModel(){
        try {
            OLLAMA.pullModel(MODEL);
            OllamaChatRequest builder = OllamaChatRequest.builder().withModel(MODEL);
        } catch (OllamaException e) {
            throw new RuntimeException(e);
        }
    }

    public String createUserQuestion(String prompt){
        OLLAMA.setRequestTimeoutSeconds(1200);
        try {
            OllamaGenerateRequest request = new OllamaGenerateRequest(MODEL, prompt);
            OllamaResult result = OLLAMA.generate(request, null);
            return result.getResponse();
        } catch (OllamaException e) {
            throw new RuntimeException(e);
        }
    }



}
