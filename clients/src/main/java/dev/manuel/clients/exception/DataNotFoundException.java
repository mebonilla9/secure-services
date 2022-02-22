package dev.manuel.clients.exception;

import dev.manuel.clients.lasting.EMessage;

public class DataNotFoundException extends SecureAppException{

  public DataNotFoundException(EMessage eMessage) {
    super(eMessage);
  }

}
