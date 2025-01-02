package com.aiflirt.profile;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ProfileValidator {
    private final ProfileRepository profileRepository;

    public Profile checkForProfile(UUID profileId) {
      return profileRepository.findById(profileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation with id "+profileId +" not found"));
    }
}
