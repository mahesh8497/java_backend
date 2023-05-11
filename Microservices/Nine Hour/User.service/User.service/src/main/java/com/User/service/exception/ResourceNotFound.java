package com.User.service.exception;

public class ResourceNotFound  extends  RuntimeException{
     public ResourceNotFound(){
         super("Resource Not found on server..!");
     }
     public ResourceNotFound(String message){
         super(message);
     }
}
