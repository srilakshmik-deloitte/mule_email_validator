package org.mule.extension.customCustom.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class EmailvalidatorOperations {

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config EmailvalidatorConfiguration configuration, @Connection EmailvalidatorConnection connection){
    return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";
  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String sayHi(String person) {
    return buildHelloMessage(person);
  }
  
  @MediaType(value = ANY, strict = false)
  public Boolean emailValidator(String email) {
    return validator(email);
  }

  /**
   * Private Methods are not exposed as operations
   */
  private String buildHelloMessage(String person) {
    return "Hello " + person + "!!!";
  }
   private Boolean validator(String email) {
	   String regex = "^(.+)@(.+)$";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(email);
       if(matcher.matches()){
           return true;
       }
       else
           return false;
   }
  
//  @MediaType(value = ANY, strict = false)
//  public class EmailValidator{
//	  
//	  private static final String EMAIL_REGEX="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//	  private static final String DOMAIN_REGEX="^[A-Za-z0-9.-]+$";
//	  public boolean validateEmail(String email) {
//		  if(!isValidFormat(email)) {
//			  return false;
//		  }
//		  if (!isValidDomain(email)) {
//			  return false;
//		  }
//		  return true;
//	  }
//	  private boolean isValidFormat(String email) {
//		  Pattern pattern = Pattern.compile(EMAIL_REGEX);
//		  Matcher matcher=pattern.matcher(email);
//		  return matcher.matches();
//	  }
//	  private boolean isValidDomain(String email) {
//		  String domain=email.substring(email.lastIndexOf("@")+1);
//		  
//		  Pattern pattern=Pattern.compile(DOMAIN_REGEX);
//		  Matcher matcher =pattern.matcher(domain);
//		  return matcher.matches();
//	  }
//  }
}
