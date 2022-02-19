package dev.manuel.clients.authority;

import dev.manuel.clients.user.UserRegistrationRequest;

public record CredentialRequest(
    String email,
    String userName,
    String password,
    UserRegistrationRequest userRegistrationRequest) {
}
