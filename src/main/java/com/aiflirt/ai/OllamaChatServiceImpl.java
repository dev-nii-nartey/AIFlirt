package com.aiflirt.ai;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Ollama-specific implementation of the ChatService interface.
 * This implementation uses Spring AI's Ollama integration.
 */
@Service
@AllArgsConstructor
public class OllamaChatServiceImpl implements ChatService {
    
    private final OllamaChatModel chatModel;
    private final Map<String, PromptTemplate> promptTemplateMap;
    
    @Override
    public String sendMessage(String message) {
        Prompt prompt = new Prompt(message);
        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getContent();
    }
    
    @Override
    public String sendTemplatedMessage(String templateName, Map<String, Object> variables) {
        PromptTemplate template = promptTemplateMap.get(templateName);
        if (template == null) {
            throw new IllegalArgumentException("Template not found: " + templateName);
        }
        
        Prompt prompt = new Prompt(template.render(variables));
        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getContent();
    }
} 