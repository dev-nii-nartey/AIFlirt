package com.aiflirt.conversation;

import java.util.List;
import java.util.UUID;

public record Conversation (UUID id,UUID authorId, UUID profileId, List<ChatMessage> messages) {}

