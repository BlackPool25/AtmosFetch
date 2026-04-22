package com.spring.atmosfetch.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {

    private final ChatClient chatClient;

    public OllamaService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateResponse(String content) {
        return chatClient.prompt()
                .user(content)
                .call()
                .content();
    }

    public String generateResponseWithLimit(String content) {
        final int limit = 1000;
        String promptWithBrainLimit = content + "(You must Strictly finish your answer within " + limit + " tokens including thinking)";

        return chatClient.prompt()
                .user(promptWithBrainLimit)
                .options(OllamaChatOptions.builder()
                        .disableThinking()
                        .maxTokens(limit)
                        .build())
                .call()
                .content();
    }
}
