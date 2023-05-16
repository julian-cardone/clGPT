package com.jc.clGPT.user;

import jakarta.transaction.Transactional;

public class UserService {

    @Transactional(rollbackFor = Exception.class)
    public String saveDto(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder
                .encode(userDto.getPassword()));
        return save(new User(userDto)).getId();
    }

}
