package com.nestedcode.exceptionNC;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MyErrorController implements ErrorController {

    public MyErrorController() {}

    @GetMapping(value = "/error")
    public void handleError(HttpServletRequest request) {
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
        
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
            	throw new NullPointerException();
                //return "error-404";
            }
           
        }
       // return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}