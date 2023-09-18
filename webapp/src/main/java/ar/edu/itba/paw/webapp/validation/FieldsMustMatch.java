package ar.edu.itba.paw.webapp.validation;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsMustMatchValidator.class)
public @interface FieldsMustMatch {
    String [] fields();
    String message() default "{askjdklasj}";



}
