package com.vagabondlab.messinn.util.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Shaiful Islam palash | <kuvic16@gmail.com>
 * @since version 0.0.1
 */
public class PropertyManager implements IPropertyManager {

    private static final Log logger = LogFactory.getLog(PropertyManager.class);
    
    // old properties saved in the file system previously
    private Properties oldProperties = new Properties();
    
    // new properties are set by user and not yet saved in the file
    private Properties newProperties = new Properties();
    private File file;

    public PropertyManager(String absoluteFilePath) {
        file = new File(absoluteFilePath);
        load();
    }

    public void load() {
        try {
            if (!file.exists()) {
                file.createNewFile();
                oldProperties.store(new FileOutputStream(file), "Application Properties");
                return;
            }
            oldProperties.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            logger.error("erp.properties file not found");
        } catch (IOException e) {
            logger.error("Can not read from file erp.properties");
        }
    }

    public void save() {
        if (newProperties.isEmpty()) {
            return;
        }
        
        @SuppressWarnings("rawtypes")
		Enumeration newKeys = newProperties.keys();
        while (newKeys.hasMoreElements()) {
            String key = (String) newKeys.nextElement();
            String keyValue = newProperties.getProperty(key);
            if (!oldProperties.containsKey(key)) {
                oldProperties.put(key, keyValue);
            } else {
                oldProperties.setProperty(key, keyValue);
            }
        }
        try {
            oldProperties.store(new FileOutputStream(file), "Application Properties");
        } catch (FileNotFoundException e) {
            logger.error("erp.properties file not found");
        } catch (IOException e) {
            logger.error("Can not write to file erp.properties");
        }

    }

    public String getProperty(String property) {
        return oldProperties.getProperty(property);
    }

    public String getPropertyAsDynamic(String property) {
        return oldProperties.getProperty(property);
    }
    
    public void setProperty(String property, String plainText) {
        newProperties.setProperty(property, plainText);
    }        
}
