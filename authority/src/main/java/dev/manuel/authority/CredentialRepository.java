package dev.manuel.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

  Optional<Credential> findByEmailOrUserName(String email, String userName);
}
