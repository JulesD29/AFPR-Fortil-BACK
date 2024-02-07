package group.fortil.validation;

import group.fortil.business.IMessageBusiness;
import group.fortil.repository.MessageRepository;
import group.fortil.service.IMessageService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

import java.time.Instant;
import java.util.Date;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentDateParameterValidator implements ConstraintValidator<ConsistentDateParameters, Date> {
    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {

        Date publicationDate ;
        Date modificationDate;


        return false;
    }

//    @Override
//    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
//
//        if (value[0] == null || value[1] == null)
//            return true;
//
//        if (!(value[0] instanceof Date) || !(value[1] instanceof Date)){
//            throw new IllegalArgumentException( "Illegal method signature, expected two parameters of type Date.");
//        }
//
//        return ((Date) value[0]).before(Date.from(Instant.now()))               // Creation date before now
//                && ((Date) value[0]).before((Date) value[1]);                   // Creation date before modification date
//    }


}
