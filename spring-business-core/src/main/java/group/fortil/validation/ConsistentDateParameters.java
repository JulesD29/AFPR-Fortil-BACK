package group.fortil.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Constraint(validatedBy = ConsistentDateParameterValidator.class)
@Target({PARAMETER, FIELD, METHOD, CONSTRUCTOR})
@Retention(RUNTIME)
@Documented
public @interface ConsistentDateParameters {

    String message() default
        "Modification date must be after creation date and both must be in the past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
