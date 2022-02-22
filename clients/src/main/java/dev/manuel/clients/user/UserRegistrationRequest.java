package dev.manuel.clients.user;

import dev.manuel.clients.authority.CredentialRequest;

public record UserRegistrationRequest(
  Integer id,
  String fullName,
  String phone,
  String document,
  String address,
  CredentialRequest credential) {

}
