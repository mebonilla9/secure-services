package dev.manuel.authority;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Credential {

  @Id
  @SequenceGenerator(
    name = "credential_id_sequence",
    sequenceName = "credential_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "credential_id_sequence"
  )
  private Integer id;

  @Column(unique = true)
  private String email;
  @Column(unique = true)
  private String userName;
  private String password;
  private Integer userId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Credential that = (Credential) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
