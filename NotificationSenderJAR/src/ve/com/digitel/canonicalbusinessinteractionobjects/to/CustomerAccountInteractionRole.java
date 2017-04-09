package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "interactionRole", "customerAccount"})
public class CustomerAccountInteractionRole implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = -127647905634467291L;

	/**
	 * Rol que define la cuenta.
	 */	
	@XmlElement(required=false, nillable=false)	
	private String interactionRole;	
	
	/**
	 * 	Objeto que contiene la información de la cuenta.
	 */	
	@XmlElement(required=true, nillable=false)		
	private CustomerAccount customerAccount;

	/**
	 * <p>Constructor default without parameters.
	 */			
	public CustomerAccountInteractionRole() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */	
	public CustomerAccountInteractionRole(String interactionRole,
			CustomerAccount customerAccount) {
		super();
		this.interactionRole = interactionRole;
		this.customerAccount = customerAccount;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the interactionRole.
	 * 
	 * @return <code>interactionRole</code>.
	 */
	public String getInteractionRole() {
		return interactionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the interactionRole.
	 * 
	 * @param <code>interactionRole</code>.
	 */
	public void setInteractionRole(String interactionRole) {
		this.interactionRole = interactionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the customerAccount.
	 * 
	 * @return <code>customerAccount</code>.
	 */
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the customerAccount.
	 * 
	 * @param <code>customerAccount</code>.
	 */
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
}
