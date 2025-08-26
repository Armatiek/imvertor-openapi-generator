package nl.imvertor.mim.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import nl.imvertor.mim.validation.KeuzeValidator;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Keuzen.class)
@Constraint(validatedBy = KeuzeValidator.class)
@Documented
public @interface Keuze {
  String message() default "Only one field must be non-zero";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String[] fieldNames();
}