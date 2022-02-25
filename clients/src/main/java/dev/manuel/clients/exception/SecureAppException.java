package dev.manuel.clients.exception;

import dev.manuel.clients.lasting.EMessage;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecureAppException extends Exception{

  private Integer code;
  private String message;

  public SecureAppException(EMessage eMessage){
    this.code = eMessage.getCode();
    this.message = eMessage.getMessage();
  }

}
