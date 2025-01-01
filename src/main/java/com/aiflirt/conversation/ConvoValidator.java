package com.aiflirt.conversation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class ConvoValidator {

    private final ConversationRepository convRepo;

    public Conversation existingConvo(UUID profileId) {
        return convRepo.findByProfileId(profileId);
    }
}
