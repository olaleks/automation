package com.stormnet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.openqa.selenium.NotFoundException;

import java.io.IOException;

public class ConfigLoader {
    private static final String PATH_TO_FILE = "test.config.json";

    private final ObjectMapper mapper;

    public ConfigLoader() {
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        this.mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    }

    public ConfigModel getConfigModel() {
        try {
            return mapper.readValue(getClass().getClassLoader().getResource(PATH_TO_FILE),
                    new TypeReference<>() {});
        } catch (IOException e) {
            throw new NotFoundException("Expected to have test properties read from file:  " + PATH_TO_FILE
                    + "\nDetail message: " + e.getMessage());
        }
    }

}
