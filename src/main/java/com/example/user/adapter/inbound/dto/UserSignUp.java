package com.example.user.adapter.inbound.dto;

import com.example.user.adapter.inbound.dto.UserSignUp.Request;
import com.example.user.adapter.inbound.dto.UserSignUp.Response;
import javax.validation.constraints.NotBlank;
import lombok.Builder;

public sealed interface UserSignUp permits Request, Response {

  record Request(
    @NotBlank(message = "이메일이 비어있습니다.")
    String email,

    @NotBlank(message = "이름이 비어있습니다.")
    String userName,

    @NotBlank(message = "비밀번호가 비어있습니다.")
    String password,

    @NotBlank(message = "닉네임이 비어있습니다.")
    String nickName
  ) implements UserSignUp {
    @Builder
    public Request {
    }
  }

  record Response(
    Long userId
  ) implements UserSignUp {
    @Builder
    public Response {
    }
  }

}
