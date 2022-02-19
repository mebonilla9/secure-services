package dev.manuel.clients.user;

public record UserRegistrationRequest(
  Integer id,
  String fullName,
  String phone,
  String document,
  String address) {

}
