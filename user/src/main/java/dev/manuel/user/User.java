package dev.manuel.user;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "`user`")
public class User {

  @Id
  @SequenceGenerator(
    name = "user_id_sequence",
    sequenceName = "user_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "user_id_sequence"
  )
  private Integer id;
  private String fullName;
  private String email;
  private String userName;
  private String password;

}
