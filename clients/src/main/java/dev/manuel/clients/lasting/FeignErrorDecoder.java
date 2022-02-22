package dev.manuel.clients.lasting;

import com.google.gson.Gson;
import dev.manuel.clients.exception.SecureAppException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeignErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String s, Response response) {
    SecureAppException exception = new SecureAppException();
    if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
      String replace = response.body().toString();//.replaceAll("^\"|\"$", "");
      System.out.println(replace);
      ExceptionResponse exceptionResponse = new Gson().fromJson(
          replace,
          ExceptionResponse.class
        );
        exception = new SecureAppException(exceptionResponse.getMessage());
    }
    return exception;
  }

}
