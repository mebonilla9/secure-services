package dev.manuel.authority;

import dev.manuel.clients.authority.CredentialRequest;
import dev.manuel.clients.exception.SecureAppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/credentials")
public record CredentialController(CredentialService credentialService) {

  @PostMapping
  public ResponseEntity<Integer> registerCredential(@RequestBody CredentialRequest credentialRequest) throws SecureAppException {
    log.info("New credential registration {}", credentialRequest);
    Integer credentialId = credentialService.registerNewCredential(credentialRequest);
    return new ResponseEntity<>(credentialId, HttpStatus.OK);
  }



}
