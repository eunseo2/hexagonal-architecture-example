package com.example.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name ="id",columnDefinition = "BIGINT")
  private Long id;

  @Pattern(regexp = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b")
  @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
  private String email;

  @Column(name = "username", columnDefinition = "VARCHAR(50)", nullable = false)
  private String username;

  @Column(name = "password", columnDefinition = "VARCHAR(100)", nullable = false)
  private String password;

  @Column(name = "nickname", columnDefinition = "VARCHAR(50)", unique = true)
  private String nickname;

  @Builder
  public User(
    String email,
    String username,
    String password,
    String nickname
  ) {
    this.email = email;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
  }
}
