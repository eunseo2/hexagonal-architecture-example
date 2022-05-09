package com.example.user.domain.converter;

import com.example.user.adapter.inbound.dto.UserSignUp;
import com.example.user.domain.User;
import org.springframework.stereotype.Component;


@Component
public class UserConverter {
  public User toEntity(UserSignUp.Request request) {
    return User.builder()
      .email(request.email())
      .nickname(request.nickName())
      .password(request.password())
      .username(request.userName())
      .build();
  }

}
