package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConsultaChatGPT {

    private static Dotenv dotenv;

    private ConsultaChatGPT(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public static String obterTraducao(String texto) {
        String apikey = dotenv.get("OPENAI_API_KEY");
        OpenAiService service = new OpenAiService(apikey);

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