package dev.manuel.authority;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

  Optional<Credential> findByEmail(String email);
}
