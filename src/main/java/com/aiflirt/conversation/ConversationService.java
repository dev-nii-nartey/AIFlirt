package com.aiflirt.conversation;

import java.util.UUID;

public interface ConversationService {
     ConversationDto startConversation(UUID authorId, ChatRequest chatRequest);

     ConversationDto sendMessage(SendMessage message,UUID authorId, UUID conversationId);

     ConversationDto getConversation(UUID user, UUID conversationId);
}
