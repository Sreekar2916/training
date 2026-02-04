package com.uniquehire.training.dto;

import com.uniquehire.training.model.UserProfile;

public class UserResponseDTO {
    private Long id;
    private String name;
    private UserProfileDTO profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(UserProfileDTO profile) {
        this.profile = profile;
    }
}
