package com.aiflirt;

import com.aiflirt.conversation.Conversation;
import com.aiflirt.conversation.ChatMessage;
import com.aiflirt.conversation.ConversationRepository;
import com.aiflirt.profile.Gender;
import com.aiflirt.profile.Profile;
import com.aiflirt.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Slf4j
@Data
@AllArgsConstructor
public class AIFlirt implements CommandLineRunner {

	private ProfileRepository profileRepository ;
	private ConversationRepository conversationRepository ;

	public static void main(String[] args) {
		SpringApplication.run(AIFlirt.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profile newbie = new Profile
				(UUID.randomUUID(),
						"Nii",
						28,
						"Fante",
						Gender.MALE,
						"Mr. Wealthy",
						"",
						"Lively",
						new ArrayList<UUID>());

		Profile savedProfile = profileRepository.save(newbie);
		log.warn("newbie {}", savedProfile);


Conversation conversation = new Conversation(
		UUID.randomUUID(),
		newbie.id(),
		List.of(
				new ChatMessage(1L,
						"Hello There",
						LocalDateTime.now(),
						newbie.id())
		)
);
Conversation savedConversation = conversationRepository.save(conversation);



newbie.conversationsIds().add(conversation.id());

		log.warn("started conversation:  {}", savedProfile);

		log.warn("The conversation {}", savedConversation);



	}
}
