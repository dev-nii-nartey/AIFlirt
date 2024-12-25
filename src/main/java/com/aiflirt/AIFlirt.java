package com.aiflirt;

import com.aiflirt.profile.Gender;
import com.aiflirt.profile.Profile;
import com.aiflirt.profile.ProfileRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
@Slf4j
@Data
public class AIFlirt implements CommandLineRunner {

	private ProfileRepository profileRepository ;

	public static void main(String[] args) {
		SpringApplication.run(AIFlirt.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profile newbie = new Profile(UUID.randomUUID(),"Nii",28,"Fante", Gender.MALE,"Mr. Wealthy","","Lively",new ArrayList<UUID>());

		Profile saved = profileRepository.save(newbie);
		log.warn("newbie {}", saved);
	}
}
