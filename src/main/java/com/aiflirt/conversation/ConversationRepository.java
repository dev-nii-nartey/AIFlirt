package com.aiflirt.conversation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ConversationRepository extends MongoRepository<Conversation, UUID> {
}
