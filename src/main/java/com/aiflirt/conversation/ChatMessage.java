package com.aiflirt.conversation;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatMessage(UUID id, String text, LocalDateTime time, UUID authorId) {}
