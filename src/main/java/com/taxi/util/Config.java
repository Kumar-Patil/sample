package com.taxi.util;

import com.taxi.exception.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Config {

    Properties configFile;
    static final Logger LOG = Logger.getLogger(Config.class);

    public Config() throws FileNotFoundException {
        configFile = new java.util.Properties();
        try {
            configFile.load(this.getClass().getClassLoader().
                    getResourceAsStream("config.properties"));
        } catch (IOException ex) {
            throw new FileNotFoundException("Config.properties file not found {}" + ex.getMessage());
        }
    }

    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }
}
