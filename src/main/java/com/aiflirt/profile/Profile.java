package com.aiflirt.profile;


import java.util.List;
import java.util.UUID;

public record Profile(UUID id, String name, int age, String ethnicity, Gender gender, String bio, String imageUrl, String personalityType, List<UUID> conversationsIds) {
}
