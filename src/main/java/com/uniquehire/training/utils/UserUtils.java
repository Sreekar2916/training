package com.uniquehire.training.utils;

import com.uniquehire.training.dto.UserProfileDTO;
import com.uniquehire.training.dto.UserResponseDTO;
import com.uniquehire.training.model.User;
import com.uniquehire.training.model.UserProfile;

public class UserUtils {

    public UserResponseDTO prepareUserResponse(User user){
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName(user.getName());
        responseDTO.setId(user.getId());
        UserProfileDTO profileDTO = prepareUserProfile(user.getProfile());
        responseDTO.setProfile(profileDTO);
        return  responseDTO;
    }

    public UserProfileDTO prepareUserProfile(UserProfile profile){
        UserProfileDTO profileDTO = new UserProfileDTO();
        profileDTO.setAddress(profile.getAddress());
        profileDTO.setPhone(profile.getPhone());
        return profileDTO;
    }
}
