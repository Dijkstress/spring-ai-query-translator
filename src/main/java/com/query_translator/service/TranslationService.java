package com.query_translator.service;

import com.query_translator.core.Prompts;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class TranslationService {

    private final ChatClient chatClient;

    public TranslationService(OllamaChatModel ollamaChatModel){
        this.chatClient=ChatClient.create(ollamaChatModel);
    }

    public String translate(String naturalQuery, String dbType) {
        String rawResponse= Objects.requireNonNull(chatClient.prompt()
                        .system(Prompts.SYSTEM)
                        .user(Prompts.prompt(dbType,naturalQuery))
                        .call()
                        .content())
                .trim();
        return cleanResponse(rawResponse);
    }

    private String cleanResponse(String rawResponse) {
        if (rawResponse == null) return "";
        return rawResponse.replaceAll("(?s)<think>.*?</think>", "").trim();
    }
}
