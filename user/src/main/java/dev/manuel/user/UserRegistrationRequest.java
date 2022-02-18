package dev.manuel.user;

public record UserRegistrationRequest(
  String fullName,
  String email,
  String userName,
  String password) {

}
