package spring.project.beetech_spring_project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.project.beetech_spring_project.entity.User;
import spring.project.beetech_spring_project.entity.UserDTO;
import spring.project.beetech_spring_project.entity.UserMapper;

@Service
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void registerUser(UserDTO userDTO) {
        User registeredUser = userMapper.toEntity(userDTO);

        log.info(registeredUser.toString());
        //userRepository.save(registeredUser)
    }
}
