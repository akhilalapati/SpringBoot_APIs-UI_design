package com.example.mapperDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final MapperChoice mapperChoice = new MapperChoice();

    public MapperChoice getMapperChoice() {
        return mapperChoice;
    }

    public static class MapperChoice {

        private boolean manipulateMapper;

        public boolean getManipulateMapper() {
            Random random = new Random();
            int  bound10Int = random.nextInt(10);
            return bound10Int%2==0;
        }

        public void setManipulateMapper(boolean manipulateMapper) {
            this.manipulateMapper = manipulateMapper;
        }

    }
}
