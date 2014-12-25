package com.vagabondlab.messinn.util.properties;


/**
 * @author Shaiful Islam palash | <kuvic16@gmail.com>
 * @since version 0.0.1
 */

public interface IPropertyManager {

	public abstract void load();

	public abstract void save();

	public abstract void setProperty(String property, String plainText);

	public abstract String getProperty(String property);

	public abstract String getPropertyAsDynamic(String property);
}
