package dev.manuel.authority;

import dev.manuel.clients.SecureAppException;
import dev.manuel.clients.authority.CredentialRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record CredentialService(CredentialRepository credentialRepository) {

  public void registerNewCredential(CredentialRequest request) throws SecureAppException {
    Credential credential = Credential.builder()
      .email(request.email())
      .password(request.password())
      .userName(request.userName())
      .userId(request.userRegistrationRequest().id())
      .build();
    // TODO Check if email valid
    EmailValidator.checkEmail(credential.getEmail());
    // TODO Check if email not taken
    Optional<Credential> existentCredentialOptional = credentialRepository.findByEmail(credential.getEmail());
    if (existentCredentialOptional.isPresent()){
      throw new SecureAppException();
    }
    // TODO register credential into db
    credentialRepository.save(credential);
  }

}
