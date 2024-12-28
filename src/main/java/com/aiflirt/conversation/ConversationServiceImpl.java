package com.aiflirt.conversation;


import com.aiflirt.profile.ProfileRepository;
import com.aiflirt.profile.ProfileValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Data
public class ConversationServiceImpl implements ConversationService {

    private ConversationRepository conversationRepository;
    private ProfileRepository profileRepository;
    private ProfileValidator validator;

    @Override
    public ConversationDto startConversation(ChatRequest chatRequest) {
        validator.checkForProfile(chatRequest.profileId());

        Conversation conversation = new Conversation(
                UUID.randomUUID(),
                chatRequest.profileId(),
               new ArrayList<>()
        );
        Conversation save = conversationRepository.save(conversation);
        return new ConversationDto(save.id(),save.profileId(),save.messages());
    }

}
