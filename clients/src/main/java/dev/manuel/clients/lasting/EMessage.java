package dev.manuel.clients.lasting;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EMessage {

  ERROR_INVALID_EMAIL(-1,"Formato de correo electronico invalido"),
  ERROR_USER_REGISTERED(-1,"El usuario que intenta registrar ya se encuentra en la plataforma"),
  DATA_NOT_FOUND(0,"Datos no encontrados");

  private final Integer code;
  private final String message;

}
