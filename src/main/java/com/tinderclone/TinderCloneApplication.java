package com.tinderclone;

import com.tinderclone.profile.Profile;
import com.tinderclone.profile.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TinderCloneApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository ;

	public static void main(String[] args) {
		SpringApplication.run(TinderCloneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profile newbie = new Profile("1U","Nii",17L,"Fante","Male","Mr. Wealthy","","Lively");

		Profile saved = profileRepository.save(newbie);
		log.info("newbie {}", saved);
	}
}
