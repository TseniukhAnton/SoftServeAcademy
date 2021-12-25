package org.softserveacademy.util;

import org.softserveacademy.exception.ApplicationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static final String PROPERTY_FILE_NAME = "application.properties";

    private Properties properties;

    public Properties getApplicationProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_FILE_NAME)) {
                properties.load(stream);
            } catch (IOException e) {
                throw new ApplicationException("Failed to load property file", e);
            }
        }
        return properties;
    }

}
