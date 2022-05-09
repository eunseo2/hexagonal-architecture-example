package com.example.user.port.service;

import com.example.user.adapter.inbound.dto.UserSignUp;
import com.example.user.domain.User;
import com.example.user.domain.converter.UserConverter;
import com.example.user.port.inbound.UserService;
import com.example.user.port.outbound.UserRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private UserConverter userConverter;

  public UserServiceImpl(
    UserRepository userRepository,
    UserConverter userConverter
  ) {
    this.userRepository = userRepository;
    this.userConverter = userConverter;
  }

  @Transactional
  public UserSignUp.Response signUp(UserSignUp.Request request) {
    User user = this.userRepository.save(this.userConverter.toEntity(request));
    return new UserSignUp.Response(user.getId());
  }

}
