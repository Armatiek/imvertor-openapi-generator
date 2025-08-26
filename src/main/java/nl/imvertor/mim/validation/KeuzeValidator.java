package nl.imvertor.mim.validation;

import java.lang.reflect.Field;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nl.imvertor.mim.annotation.Keuze;

public class KeuzeValidator implements ConstraintValidator<Keuze, Object> {

  private String[] fieldNames;

  @Override
  public void initialize(Keuze constraintAnnotation) {
    this.fieldNames = constraintAnnotation.fieldNames();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    int nonZeroCount = 0;
    try {
      for (String fieldName : fieldNames) {
        Field field = value.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Object fieldValue = field.get(value);
        if (fieldValue != null) {
          nonZeroCount++;
        }
      }
    } catch (Exception e) {
      return false;
    }
    return nonZeroCount == 1;
  }
  
}