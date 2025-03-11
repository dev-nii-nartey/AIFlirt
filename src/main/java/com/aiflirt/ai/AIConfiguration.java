package com.aiflirt.ai;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for AI-related beans.
 * This class centralizes the configuration of AI components and makes it easier to swap implementations.
 */
@Configuration
public class AIConfiguration {

    /**
     * Creates a map of prompt templates that can be used by the ChatService implementations.
     * Each template is identified by a key that can be used when calling sendTemplatedMessage.
     * 
     * @return A map of named prompt templates
     */
    @Bean
    public Map<String, PromptTemplate> promptTemplateMap() {
        Map<String, PromptTemplate> templates = new HashMap<>();
        
        // Add your templates here
        templates.put("profile-summary", 
            new PromptTemplate("Create a summary for a dating profile. Name: {name}, Age: {age}, Ethnicity: {ethnicity}, Gender: {gender}"));
        
        templates.put("conversation-starter", 
            new PromptTemplate("Generate a conversation starter for someone with these traits: {personalityType}"));
        
        return templates;
    }
} 