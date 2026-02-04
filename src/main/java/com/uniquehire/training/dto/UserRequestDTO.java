package com.uniquehire.training.dto;

import com.uniquehire.training.model.UserProfile;

public class UserRequestDTO {

    private String name;
    private UserProfile profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}
