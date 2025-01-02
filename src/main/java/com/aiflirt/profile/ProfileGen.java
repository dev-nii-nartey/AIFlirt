package com.aiflirt.profile;


import com.aiflirt.conversation.ConversationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@Data
@Slf4j
@Component
public class ProfileGen implements CommandLineRunner {

    private ProfileRepository profileRepo;
    private ConversationRepository conversationRepo;

    @Override
    public void run(String... args) {

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

        List<Profile> savedProfile =  profileRepo.saveAll(List.of(newbie,newbie2,newbie3));

        savedProfile.forEach(profile -> log.warn(profile.toString()));


    }
}
