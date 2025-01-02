package com.aiflirt.conversation;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ConversationDto {
    private UUID conversationId;
    private UUID authorId;
    private UUID profileId;
    private List<ChatMessage> messages;



    public ConversationDto(Conversation conversation) {
        this.conversationId = conversation.id();
        this.authorId = conversation.authorId();
        this.profileId = conversation.profileId();
        this.messages = conversation.messages();
    }
}
