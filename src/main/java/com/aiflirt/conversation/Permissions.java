package com.aiflirt.conversation;

import com.aiflirt.profile.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class Permissions {
    ProfileRepository profileRepository;
    public void isForbidden(UUID user){
        profileRepository.findById(user).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN));
    }
}
