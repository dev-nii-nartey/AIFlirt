package com.aiflirt.profile;


import com.aiflirt.ai.ChatServiceFactory;
import com.aiflirt.conversation.ConversationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@AllArgsConstructor
@Data
@Slf4j
@Component
public class ProfileGen implements CommandLineRunner {

    private ProfileRepository profileRepo;
    private ConversationRepository conversationRepo;
    private ChatServiceFactory chatServiceFactory;

    @Override
    public void run(String... args) {
        // Use the chat service abstraction instead of direct model dependencies
        String response = chatServiceFactory.getChatService().sendMessage("Are you able to generate images");
        System.out.println(response);

        profileRepo.deleteAll();
        conversationRepo.deleteAll();

        Profile newbie = new Profile
                (UUID.randomUUID(),
                        "Nii",
                        28,
                        "Fante",
                        Gender.MALE,
                        "Mr. Wealthy",
                        "",
                        "Lively",
                        new ArrayList<>());

        Profile newbie2 = new Profile
                (UUID.randomUUID(),
                        "Naa",
                        28,
                        "Fante",
                        Gender.FEMALE,
                        "Mrs. Money",
                        "",
                        "Lively",
                        new ArrayList<>());


        Profile newbie3 = new Profile
                (UUID.randomUUID(),
                        "Teiko",
                        21,
                        "Ashanti",
                        Gender.FEMALE,
                        "Mrs. Wealthy",
                        "",
                        "Lively",
                        new ArrayList<>());

        List<Profile> savedProfile = profileRepo.saveAll(List.of(newbie, newbie2, newbie3));

        savedProfile.forEach(profile -> {
            log.warn(profile.toString());
            
            // Example of using templated message with the ChatService abstraction
            Map<String, Object> variables = new HashMap<>();
            variables.put("name", profile.name());
            variables.put("age", profile.age());
            variables.put("ethnicity", profile.ethnicity());
            variables.put("gender", profile.gender());
            
            String profileSummary = chatServiceFactory.getChatService()
                .sendTemplatedMessage("profile-summary", variables);
            
            log.info("Generated profile summary: {}", profileSummary);
        });
    }
}
