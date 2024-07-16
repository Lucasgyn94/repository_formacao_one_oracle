package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.config.OpenAIConfig;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConsultaChatGPT {

    @Autowired
    private static OpenAIConfig openAIConfig;

    public static String obterTraducao(String texto) {
        String apiKey = openAIConfig.getApiKey(); // Obtém a chave do .env
        OpenAiService service = new OpenAiService(apiKey);

        ChatMessage userMessage = new ChatMessage("user", "Traduza para o português o texto: " + texto);

        ChatCompletionRequest requisicao = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(Arrays.asList(userMessage))
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createChatCompletion(requisicao);
        return resposta.getChoices().get(0).getMessage().getContent().trim();
    }
}


/*
*
* */