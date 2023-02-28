package de.telran.springdemo.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.io.IOException;

@Component
public class ResponseCodeExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override
    protected ModelAndView doResolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {

        try {
            if (ex instanceof ConstraintViolationException) {
                return handleConstraintViolation((ConstraintViolationException) ex, response, handler);
            }
        } catch (Exception ignored) {

        }

        return null;
    }

    private ModelAndView handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletResponse response,
            Object handler) throws IOException {

        System.out.println("EXCEPTION RESOLVED");
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        return new ModelAndView();
    }
}
