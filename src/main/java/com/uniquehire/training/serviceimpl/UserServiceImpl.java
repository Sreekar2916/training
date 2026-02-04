package com.uniquehire.training.serviceimpl;

import com.uniquehire.training.dto.UserProfileDTO;
import com.uniquehire.training.dto.UserRequestDTO;
import com.uniquehire.training.dto.UserResponseDTO;
import com.uniquehire.training.model.User;
import com.uniquehire.training.model.UserProfile;
import com.uniquehire.training.repository.UserProfileRepository;
import com.uniquehire.training.repository.UserRepository;
import com.uniquehire.training.service.UserService;
import com.uniquehire.training.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    /*@Autowired
    private final UserUtils userUtils;*/

    public UserServiceImpl(UserRepository userRepository, UserProfileRepository userProfileRepository/*, UserUtils userUtils*/) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
       // this.userUtils = userUtils;
    }

    public User saveUser(UserRequestDTO userDTO) {

        User user = new User();
        if(Objects.nonNull(userDTO.getName())){
            user.setName(userDTO.getName());
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setPhone(userDTO.getProfile().getPhone());
        userProfile.setAddress(userDTO.getProfile().getAddress());
        UserProfile profileResponse = userProfileRepository.save(userProfile);
        user.setProfileId(profileResponse.getId());

       // user.setProfile(userProfile);

        return userRepository.save(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> userDetails = userRepository.findAll();
        List<UserResponseDTO> userResponseList = new ArrayList<>();

        UserUtils userUtils = new UserUtils();
        for(User user : userDetails){
            UserResponseDTO responseDTO = userUtils.prepareUserResponse(user);
            userResponseList.add(responseDTO);
        }
        return userResponseList;
    }

}

