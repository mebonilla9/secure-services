package dev.manuel.clients.exception;

import dev.manuel.clients.lasting.EMessage;

public class SecureAppException extends Exception{

  public SecureAppException(){

  }

  public SecureAppException(EMessage eMessage) {
    super(eMessage.getMessage());
  }

  public SecureAppException(String message){
    super(message);
  }
}
