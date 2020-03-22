package com.EmployeeManagement.employeemanagement.impl;

        import com.EmployeeManagement.employeemanagement.dto.UserDTO;
        import com.EmployeeManagement.employeemanagement.entity.UserEntity;
        import com.EmployeeManagement.employeemanagement.repository.UserRepository;
        import com.EmployeeManagement.employeemanagement.service.UserService;
        import org.modelmapper.ModelMapper;
        import org.springframework.stereotype.Service;

        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepo, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }

    @Override
    public UserDTO save(UserDTO user) {
        UserEntity userDB = modelMapper.map(user, UserEntity.class);
        userDB = userRepo.save(userDB);
        return modelMapper.map(userDB, UserDTO.class);
    }

    @Override
    public UserDTO getByUserID(Long userId) {
        UserEntity userDB = userRepo.getOne(userId);
        return modelMapper.map(userDB, UserDTO.class);
    }

    public Boolean delete(Long id) {
        userRepo.deleteById(id);
        return true;
    }


    @Override
    public UserDTO update(Long id, UserDTO user) {
        UserEntity userFromDB = userRepo.getOne(id);
        if (userFromDB.getUserId() == null) {
            throw new IllegalArgumentException("User could not found!:" + id);
        }

        userFromDB.setUserName(user.getUserName());
        userFromDB.setPassword(user.getPassword());
        userFromDB.setUserRole(user.getUserRole());
        userFromDB.setUpdatedAt(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

        userRepo.save(userFromDB);
        return modelMapper.map(userFromDB, UserDTO.class);
    }

    @Override
    public UserDTO getByUserNameAndUserRole(UserDTO user) {
        UserEntity userDB = userRepo.getByUserNameAndUserRole(user.getUserName(), user.getUserRole());
        return modelMapper.map(userDB, UserDTO.class);
    }
}
