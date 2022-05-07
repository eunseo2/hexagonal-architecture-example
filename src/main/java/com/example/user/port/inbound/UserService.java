package com.example.user.port.inbound;

import com.example.user.adapter.inbound.dto.UserSignUp;

public interface UserService {
  UserSignUp.Response signUp(UserSignUp.Request request);
}
