package dev.manuel.clients.lasting;

import lombok.Getter;

@Getter
public enum EMessage {

  ERROR_INVALID_EMAIL("Formato de correo electronico invalido"),
  ERROR_USER_REGISTERED("El usuario que intenta registrar ya se encuentra en la plataforma"),
  DATA_NOT_FOUND("Datos no encontrados");

  private final String message;

  EMessage(String message){
    this.message = message;
  }

}
