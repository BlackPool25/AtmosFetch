package com.spring.atmosfetch.controllers;

import com.spring.atmosfetch.dto.ChatRequest;
import com.spring.atmosfetch.services.OllamaService;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class OllamaController {

    private final OllamaService ollamaService;

    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/generate")
    public String generateResponse(@RequestBody ChatRequest chatRequest) {
        return ollamaService.generateResponse(chatRequest.getContent());
    }

    @PostMapping("/generate-with-limit")
    public String generateResponseWithLimit(@RequestBody ChatRequest chatRequest) {
        return ollamaService.generateResponseWithLimit(chatRequest.getContent());
    }

}
