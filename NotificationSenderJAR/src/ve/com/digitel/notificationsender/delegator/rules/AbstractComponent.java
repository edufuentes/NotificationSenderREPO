/*
 * Copyright 2008 FYC CORP, Inc. All rights reserved.
 * FYC CORP/CONFIDENTIAL
 * */

package ve.com.digitel.notificationsender.delegator.rules;

import java.io.Serializable;
import java.util.Map;

import ve.com.digitel.notificationsender.util.Key;



/**
 * 
 *  <p>The abstract class <code>AbstractComponent</code> is a base component for execute rules.
 *
 *  @author  FYC CORP
 *  @since   09/06/2010 (Created)
 *  @since   09/06/2010 (Last update)
 *  @since   1.6
 */
public abstract class AbstractComponent implements Serializable {
	
	/* Component name. */
	protected String name = "";
	
	/* Id for serialization version. */
	private static final long serialVersionUID = 780879439785460413L;
	
	/**
	 * 
	 *  <p>Unique constructor with parameters.
	 *  
	 *  @param name The component name.
	 * */
	public AbstractComponent (String name) {
		
		// Call to super class.
		super ();
		
		// Set the internal values.
		this.name = name == null ? this.getClass ().toString () : name.trim ();
	}
	
	/***
	 * 
	 *  <p>Method that execute the rules logic.
	 * 
	 *  @param context Context for execute the business logic. 
	 */
	public abstract void execute (Map<Key, Object> args);
}