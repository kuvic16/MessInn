package com.vagabondlab.messinn.util.properties;

/**
 * @author Shaiful Islam palash | <kuvic16@gmail.com>
 * @since version 0.0.1
 */
public class PropertyFactory {
	private static IPropertyManager propertyManager = null;

	public static void init(String absoluteFilePath) {
		if (propertyManager == null) {
			propertyManager = new PropertyManager(absoluteFilePath);
		}
	}

	public static IPropertyManager getPropertyManager() {
		if (propertyManager == null) {
			throw new PropertyExcetion("property is not found before to create property instance");
		}
		return propertyManager;
	}
}
