package dev.manuel.authority;

import dev.manuel.clients.SecureAppException;

import java.util.regex.Pattern;

public final class EmailValidator{

  private static final String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

  public static void checkEmail(String email) throws SecureAppException {
    if (!Pattern.compile(regex).matcher(email).matches()){
      throw new SecureAppException();
    }
  }

}
