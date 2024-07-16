package br.com.alura.screenmatch.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    private final String apiKey;

    public OpenAIConfig() {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("OPENAI_APIKEY");
    }

    public String getApiKey() {
        return apiKey;
    }
}