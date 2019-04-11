package com.provider.eurekaserviceprovider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.provider.eurekaserviceprovider.modal.Student;

@ControllerAdvice
public class ProductExceptionController {
  /* @ExceptionHandler(value = ProductNotfoundException.class)
   public ResponseEntity<Object> exception(ProductNotfoundException exception) {
      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
   }*/
   
  /* @ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGenericException(ProductNotfoundException ex) {
	   //ResponseEntity<?> rt=new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	   //return rt;
	   return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Message", ex.getMessage()).body(ex.getMessage());
	}*/
   
   @ExceptionHandler(Exception.class)
   public ResponseEntity<Object> exception(ProductNotfoundException exception) {
	   Student s=new Student("None", "Product not found");
      return new ResponseEntity<>(s, HttpStatus.OK);
   }
   
}