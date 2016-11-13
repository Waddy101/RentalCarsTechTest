package com.adamwads.classes;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * A dummy method that flags any classes or methods with the @Path variable so that they can be read
 * by Jax-RS + RESTeasy and output. (An alternative to creating a web.xml file)
 * @author Adam Wadsworth
 */
@ApplicationPath("")
public class Config extends Application {
	
}
