package dev.manuel.authority;

import dev.manuel.clients.exception.SecureAppException;
import dev.manuel.clients.authority.CredentialRequest;
import dev.manuel.clients.lasting.EMessage;
import dev.manuel.clients.util.EmailValidator;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record CredentialService(CredentialRepository credentialRepository) {

  public Integer registerNewCredential(CredentialRequest request) throws SecureAppException {
    Credential credential = Credential.builder()
      .email(request.email())
      .password(DigestUtils.sha3_384Hex(request.password()))
      .userName(request.userName())
      .build();
    // TODO Check if email valid
    EmailValidator.checkEmail(credential.getEmail());
    // TODO Check if email not taken
    Optional<Credential> existentCredentialOptional = credentialRepository.findByEmailOrUserName(
      credential.getEmail(), credential.getUserName()
    );
    if (existentCredentialOptional.isPresent()){
      throw new SecureAppException(EMessage.ERROR_USER_REGISTERED);
    }
    // TODO register credential into db
    credentialRepository.save(credential);
    return credential.getId();
  }

}
