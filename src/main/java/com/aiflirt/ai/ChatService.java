package com.aiflirt.ai;

/**
 * A portable interface for AI chat operations that is not tied to any specific model implementation.
 * This allows for swapping between different AI model providers without changing application code.
 */
public interface ChatService {
    
    /**
     * Sends a message to the AI model and returns the response.
     * 
     * @param message The message to send to the AI model
     * @return The response from the AI model
     */
    String sendMessage(String message);
    
    /**
     * Sends a templated message to the AI model with variable replacements.
     * 
     * @param templateName The name or identifier of the template to use
     * @param variables Key-value pairs to be replaced in the template
     * @return The response from the AI model
     */
    String sendTemplatedMessage(String templateName, java.util.Map<String, Object> variables);
} 