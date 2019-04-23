package com.guga.ee;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonParserPointer {

    private static final Logger LOGGER = Logger.getLogger(JsonParserPointer.class.getName());

    public static void main(String[] args) {
        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("user.json");
            JsonReader jsonReader = Json.createReader(inputStream)){
            JsonStructure jsonStructure = jsonReader.read();
            JsonPointer jsonPointerProfile = Json.createPointer("/user/profile");
            final JsonValue jsonValueProfile = jsonPointerProfile.getValue(jsonStructure);

            JsonPointer jsonPointerUser = Json.createPointer("/user");
            final JsonValue jsonValueUser = jsonPointerUser.getValue(jsonStructure);

            LOGGER.info(() -> "From Profile"+jsonValueProfile);
            LOGGER.info(() -> "From User "+ jsonValueUser);

        } catch (IOException e) {
            LOGGER.info(() -> e.getMessage());
        }

    }
}
