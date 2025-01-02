package com.aiflirt.profile;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ProfileValidator {
    private final ProfileRepository profileRepository;

    public void checkForProfile(UUID profileId) {
       profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceAccessException("Profile not found with id: " + profileId));
    }
}
