package ar.edu.itba.paw.webapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsMustMatchValidator implements ConstraintValidator<FieldsMustMatch,Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return true;
    }
}
