package exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectDataFormatException extends ConstraintViolationException  {

    public IncorrectDataFormatException(ConstraintViolationException e) {
        this(e.getMessage(), e.getConstraintViolations());
    }

    public IncorrectDataFormatException(String message, Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(message, constraintViolations);
    }

    public IncorrectDataFormatException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(constraintViolations);
    }
}
