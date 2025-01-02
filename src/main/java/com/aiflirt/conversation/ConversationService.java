package com.aiflirt.conversation;

import java.util.UUID;

public interface ConversationService {
     ConversationDto startConversation(ChatRequest chatRequest);

     ConversationDto sendMessage(SendMessage message, UUID conversationId);
}
