/*
 * @(#IErrorHandler.java 09/03/2010
 * Copyright 2008 FYC CORP, Inc. All rights reserved.
 * FYC CORP/CONFIDENTIAL
 * */

package ve.com.digitel.notificationsender.exceptions;


// Packages and classes to import of jdk 1.6
import java.io.Serializable;


/**
 * 
 *  <p> The abstract class <code>ve.com.digitel.changecos.util.IErrorHandler</code> is an interface that define the
 *      business logic contract for management error system.
 *      
 *      
 *  @author  Raul Peña () FYC CORP
 *  @since   09/03/2010 (Created)
 *  @since   09/03/2010 (Last update)
 *  @since   1.6
 *  @see     {@link java.io.Serializable}
 */
public interface IErrorHandler<T> extends Serializable {

	
	// Public static fields declarations.
	/** Spring bean name to usage for Bean object. */
	String ERROR_HANDLER = "errorHandler";
	
	
	// Methods declarations.
	/**
	 * 
	 *  <p>Method that management the system errors.
	 *  
	 *  @param err Failure cause.
	 *  @param args Optional values.
	 * */
	 void handler (Throwable err, T args);
}