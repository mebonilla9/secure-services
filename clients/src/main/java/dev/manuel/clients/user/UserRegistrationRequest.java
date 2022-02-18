package dev.manuel.clients.user;

public record UserRegistrationRequest(
  String fullName,
  String email,
  String userName,
  String password) {

}
