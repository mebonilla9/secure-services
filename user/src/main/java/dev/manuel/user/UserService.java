package dev.manuel.user;

import dev.manuel.clients.authority.CredentialClient;
import dev.manuel.clients.authority.CredentialRequest;
import dev.manuel.clients.exception.SecureAppException;
import dev.manuel.clients.lasting.EMessage;
import dev.manuel.clients.user.UserRegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record UserService(
  UserRepository userRepository,
  CredentialClient credentialClient) {

  public void registerUser(UserRegistrationRequest request) throws SecureAppException {
    User user = User.builder()
      .fullName(request.fullName())
      .document(request.document())
      .address(request.address())
      .phone(request.phone())
      .build();
    // TODO Check if document not taken
    Optional<User> byDocument = userRepository.findByDocument(user.getDocument());
    if (byDocument.isPresent()){
      throw new SecureAppException(EMessage.ERROR_USER_REGISTERED);
    }
    // TODO send request authority service
    ResponseEntity<Integer> responseEntity = credentialClient.registerCredential(request.credential());
    user.setIdCredential(responseEntity.getBody());
    // TODO store user in db
    userRepository.save(user);
    // TODO Send credential request
  }

  //public User

}
