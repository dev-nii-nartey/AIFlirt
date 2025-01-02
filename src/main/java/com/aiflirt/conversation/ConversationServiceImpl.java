package com.aiflirt.conversation;


import com.aiflirt.profile.Profile;
import com.aiflirt.profile.ProfileRepository;
import com.aiflirt.profile.ProfileValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Data
public class ConversationServiceImpl implements ConversationService {

    private ConversationRepository conversationRepository;
    private ProfileRepository profileRepository;
    private ProfileValidator profileValidator;
    private ConvoValidator convoValidator;

    @Override
    public ConversationDto startConversation(UUID authorId, ChatRequest chatRequest) {
        profileValidator.checkForProfile(chatRequest.profileId());
        profileValidator.checkForProfile(authorId);
        Conversation conversation = convoValidator.existingConvo(chatRequest.profileId());
        if (conversation != null) {
           return new ConversationDto(conversation);
        }

        Conversation newConversation = new Conversation(
                UUID.randomUUID(),
                authorId,
               chatRequest.profileId(),
               new ArrayList<>()
        );
        Conversation save = conversationRepository.save(newConversation);
        return new ConversationDto(save);
    }

    @Override
    public ConversationDto sendMessage(SendMessage message, UUID authorId, UUID conversationId) {
        profileValidator.checkForProfile(authorId);
        Conversation conversation = convoValidator.checkForConvo(conversationId);
        convoValidator.sameAuthorProfile(message.profileId(),authorId,conversation.id());
        ChatMessage chatMessage = new ChatMessage( message.textMessage(), LocalDateTime.now(), authorId);
        conversation.messages().add(chatMessage);
        Conversation save = conversationRepository.save(conversation);
        return new ConversationDto(save);
    }

    @Override
    public ConversationDto getConversation(UUID user, UUID conversationId) {
       Profile author = profileValidator.checkForProfile(user);
        Conversation conversation = convoValidator.checkForConvo(conversationId);
        if(conversation.authorId() == author.id()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"You are not the author of this conversation");
        }
        return new ConversationDto(conversation);
    }

}
