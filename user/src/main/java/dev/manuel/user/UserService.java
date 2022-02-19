package dev.manuel.user;

import dev.manuel.clients.authority.CredentialRequest;
import dev.manuel.clients.user.UserRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepository userRepository) {

  public void registerUser(UserRegistrationRequest request) {
    User user = User.builder()
      .fullName(request.fullName())
      .document(request.document())
      .address(request.address())
      .phone(request.phone())
      .build();
    // TODO Check if document not taken
    userRepository.findByDocument(user.getDocument());
    // TODO store user in db
    userRepository.save(user);
    // TODO Send credential request
  }

}
