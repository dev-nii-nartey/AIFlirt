package com.aiflirt.conversation;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/conversation")
@AllArgsConstructor
@Data
public class ConversationController {

    private ConversationService conversationService;

    @PostMapping
    private ConversationDto CreateConversation(@RequestBody ChatRequest chatRequest){
        return conversationService.startConversation(chatRequest);
    }


    @PatchMapping("/{conversationId}")
    private ConversationDto sendMessage(@RequestBody SendMessage message, @PathVariable UUID conversationId){
        return conversationService.sendMessage(message, conversationId);
    }
}
