package com.aiflirt.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Factory for providing ChatService instances based on configuration.
 * This allows for runtime selection of different AI model providers.
 */
@Service
public class ChatServiceFactory {
    
    @Value("${aiflirt.chat.provider:ollama}")
    private String chatProvider;
    
    @Autowired
    private OllamaChatServiceImpl ollamaChatService;
    
    // Add other implementations as needed
    @Autowired
    private OpenAIChatServiceImpl openAIChatService;
    
    /**
     * Get the appropriate ChatService implementation based on configuration.
     * 
     * @return The configured ChatService implementation
     */
    public ChatService getChatService() {
        switch (chatProvider.toLowerCase()) {
            case "ollama":
                return ollamaChatService;
            case "openai":
                return openAIChatService;
            default:
                throw new IllegalStateException("Unknown chat provider: " + chatProvider);
        }
    }
} 