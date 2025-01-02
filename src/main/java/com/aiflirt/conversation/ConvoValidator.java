package com.aiflirt.conversation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.UUID;

@AllArgsConstructor
@Component
public class ConvoValidator {

    private final ConversationRepository convRepo;

    public Conversation existingConvo(UUID profileId) {
        return convRepo.findByProfileId(profileId);
    }

    public Conversation checkForConvo(UUID conversationId) {
       return convRepo.findById(conversationId).orElseThrow(
                ()-> new ResourceAccessException("Conversation with id "+conversationId +" not found")
        );
    }
}
