package com.aiflirt.conversation;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatMessage( String text, LocalDateTime time, UUID authorId) {}
