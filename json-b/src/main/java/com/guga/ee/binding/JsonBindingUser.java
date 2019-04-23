package com.guga.ee.binding;

import com.guga.ee.pojo.User;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.logging.Logger;

public class JsonBindingUser {

    private static final Logger LOGGER = Logger.getLogger(JsonBindingUser.class.getName());

    public static void main(String[] args) {
        final User user = User.UserBuilder.anUser()
                .withFirstName("Robinson")
                .withLastName("Crusoe")
                .withDob(ZonedDateTime.of(1900, 1, 2, 3, 4, 5, 3, ZoneOffset.UTC))
                .build();

        try (Jsonb jsonb = JsonbBuilder.create()) {
            LOGGER.info(jsonb.toJson(user));
        } catch (Exception e) {
            LOGGER.info(e::getMessage);
        }
    }
}
