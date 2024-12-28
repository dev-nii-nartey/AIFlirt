package com.aiflirt.conversation;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
