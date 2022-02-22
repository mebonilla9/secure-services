package dev.manuel.clients.lasting;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

  private String message;
  private LocalDateTime dateTime;

}
