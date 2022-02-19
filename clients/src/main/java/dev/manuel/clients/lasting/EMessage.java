package dev.manuel.clients.lasting;

import lombok.Getter;

@Getter
public enum EMessage {

  ERROR_INVALID_EMAIL(-1, "Formato de correo electronico invalido"),
  ERROR_USER_REGISTERED(-1, "El usuario que intenta registrar ya se encuentra en la plataforma");

  private final int code;
  private final String message;

  EMessage(int code, String message){
    this.code = code;
    this.message = message;
  }

}
