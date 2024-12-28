package com.aiflirt.conversation;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class ConversationDto {
    private UUID id;
    private UUID profileId;
    private List<ChatMessage> messages;

    public ConversationDto(UUID id, UUID profileId, List<ChatMessage> messages) {
        this.id = id;
        this.profileId = profileId;
        this.messages = messages;
    }

//    public ConversationDto(Conversation conversation) {
//        this.id = conversation.id();
//        this.profileId = conversation.profileId();
//        this.messages = conversation.messages();
//    }
}
