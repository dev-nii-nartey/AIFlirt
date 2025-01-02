package com.aiflirt.conversation;


import com.aiflirt.profile.ProfileRepository;
import com.aiflirt.profile.ProfileValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ConversationDto startConversation(ChatRequest chatRequest) {
        profileValidator.checkForProfile(chatRequest.profileId());
        profileValidator.checkForProfile(chatRequest.authorId());
        Conversation conversation = convoValidator.existingConvo(chatRequest.profileId());
        if (conversation != null) {
           return new ConversationDto(conversation);
        }

        Conversation newConversation = new Conversation(
                UUID.randomUUID(),
                chatRequest.authorId(),
               chatRequest.profileId(),
               new ArrayList<>()
        );
        Conversation save = conversationRepository.save(newConversation);
        return new ConversationDto(save);
    }

    @Override
    public ConversationDto sendMessage(SendMessage message, UUID conversationId) {
        profileValidator.checkForProfile(message.authorId());
        Conversation conversation = convoValidator.checkForConvo(conversationId);
        ChatMessage chatMessage = new ChatMessage( message.textMessage(), LocalDateTime.now(), message.authorId());
        conversation.messages().add(chatMessage);
        Conversation save = conversationRepository.save(conversation);
        return new ConversationDto(save);
    }

}
