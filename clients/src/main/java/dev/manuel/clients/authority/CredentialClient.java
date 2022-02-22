package dev.manuel.clients.authority;

import dev.manuel.clients.exception.SecureAppException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("authority")
public interface CredentialClient {

  @PostMapping("api/v1/credentials")
  ResponseEntity<Integer> registerCredential(@RequestBody CredentialRequest credentialRequest) throws SecureAppException;
}
