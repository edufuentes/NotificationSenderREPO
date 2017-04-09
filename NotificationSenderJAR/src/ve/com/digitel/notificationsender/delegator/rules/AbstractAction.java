/*
 * Copyright 2008 FYC CORP, Inc. All rights reserved.
 * FYC CORP/CONFIDENTIAL
 * */

package ve.com.digitel.notificationsender.delegator.rules;

import java.util.Map;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationsender.util.Key;



/**
 * 
 *  <p>The abstract class <code>AbstractAction</code> is a base action for execute rules.
 *
 *  @author  FYC CORP
 *  @since   09/06/2010 (Created)
 *  @since   09/06/2010 (Last update)
 *  @since   1.6
 */
public abstract class AbstractAction extends AbstractComponent {

	/* Define the next component to execute. */
	private AbstractComponent nextStep = null;

	/* Logger object. */
	protected Logger logger = BSSIntLogger.getBSSIntLogger (AbstractAction.class);

	/* Id for serialization version. */
	private static final long serialVersionUID = 780879459775470433L;

	/**
	 * 
	 *  <p>Constructor with parameters.
	 *  
	 *  @param name Action name.
	 * */
	public AbstractAction (String name) {

		// Call to super class.
		super (name);
	}

	/**
	 * 
	 *  <p>Method that execute the business logic.
	 *  
	 *  @param context Context rules business logic.
	 * */
	protected abstract void doExecute (Map<Key, Object> context);


	/**
	 * 
	 *  <p>Method that set the next step to execute.
	 *  
	 *  @param nextStep Next component to execute.
	 * */
	public void setNextStep (AbstractComponent nextStep) {

		// Set the next step.
		this.nextStep = nextStep;
	}

	/**
	 * 
	 *  <p>Method that return the next step to execute.
	 *  
	 *  @param nextStep Next component to execute.
	 * */
	public AbstractComponent getNextStep () {

		// Return the next step.
		return nextStep;
	}

	@Override
	public final void execute (Map<Key, Object> context) {

		this.doExecute (context);

		if (nextStep != null) {
			nextStep.execute (context);
		}
	}
	
}