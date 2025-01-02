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
    private ConversationDto CreateConversation(@RequestHeader UUID user, @RequestBody ChatRequest chatRequest){
        return conversationService.startConversation(user, chatRequest);
    }

    @PatchMapping("/{conversationId}")
    private ConversationDto sendMessage(@RequestHeader UUID user, @RequestBody SendMessage message, @PathVariable UUID conversationId){
        return conversationService.sendMessage(message,user, conversationId);
    }

    @GetMapping("/{conversationId}")
    private ConversationDto getConversation(@RequestHeader UUID user, @PathVariable UUID conversationId){
        return conversationService.getConversation(user,conversationId);
    }
}
