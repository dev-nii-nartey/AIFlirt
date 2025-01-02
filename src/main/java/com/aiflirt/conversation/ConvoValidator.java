package com.aiflirt.conversation;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

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
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation with id "+conversationId +" not found")
        );
    }

    public void  sameAuthorProfile(UUID profileId, UUID authorId,UUID convoId) {
        Conversation conversation = checkForConvo(convoId);
      boolean valid = conversation.profileId().equals(profileId) && conversation.authorId().equals(authorId);
            if (!valid) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
    }
}
