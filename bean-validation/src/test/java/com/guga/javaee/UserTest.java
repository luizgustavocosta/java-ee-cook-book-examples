package com.guga.javaee;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class UserTest implements WithAssertions {

    @Test
    void given_an_user_when_fields_then_validate() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Address address = new Address(null, null);

        final Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);

        assertThat(constraintViolations.isEmpty()).isFalse();

        User anUser = new User(null, null, null, null);
        final Set<ConstraintViolation<User>> validate = validator.validate(anUser);
        assertThat(validate.iterator().hasNext()).isTrue();
    }

}
