package dev.manuel.user;

import dev.manuel.clients.user.UserRegistrationRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepository userRepository) {

  public void registerUser(UserRegistrationRequest request) {
    User user = User.builder()
      .fullName(request.fullName())

      .build();
    // TODO Check if email valid
    // TODO Check if email not taken
    // TODO Check if email not taken
    // TODO store user in db
    userRepository.save(user);
  }

}
