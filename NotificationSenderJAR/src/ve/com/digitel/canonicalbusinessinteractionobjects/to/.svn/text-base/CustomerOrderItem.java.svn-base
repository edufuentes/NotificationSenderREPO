package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "action", "description","customerAccountInteractionRole","partyInteractionRole","functionalMessage","errorMessage" })
public class CustomerOrderItem implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = -6374597170144124529L;

	/**
	 * Identificador del ítem.
	 */	
	@XmlElement(required=false, nillable=false)
	private String id;	
	
	/**
	 * Acción a ejecutar sobre el producto.
	 */	
	@XmlElement(required=false, nillable=false)
	private String action;	
	
	/**
	 * Descripción de ítem.
	 */	
	@XmlElement(required=false, nillable=false)
	private String description;
	
	/**
	 * Objeto que contiene la información de los roles que puede tener una cuenta de usuario.
	 */		
	@XmlElement(required=true, nillable=false)
	private List<CustomerAccountInteractionRole> customerAccountInteractionRole;
	
	/**
	 * Objeto que contiene la información del canal.
	 */	
	@XmlElement(required=false, nillable=false)
	private PartyInteractionRole partyInteractionRole;	
	
	/**
	 * Objeto que contiene la información del mensaje funcional que retorna el servicio.
	 */		
	@XmlElement(required=false, nillable=false)
	private FunctionalMessage functionalMessage;
	
	/**
	 * Objeto que contiene la información del mensaje de error técnico que retorna el servicio.
	 */		
	@XmlElement(required=false, nillable=false)
	private ErrorMessage errorMessage;

	/**
	 * <p>Constructor default without parameters.
	 */		
	public CustomerOrderItem() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */
	public CustomerOrderItem(String id, String action, String description,
			List<CustomerAccountInteractionRole> customerAccountInteractionRole,
			PartyInteractionRole partyInteractionRole,
			FunctionalMessage functionalMessage, ErrorMessage errorMessage) {
		super();
		this.id = id;
		this.action = action;
		this.description = description;
		this.customerAccountInteractionRole = customerAccountInteractionRole;
		this.partyInteractionRole = partyInteractionRole;
		this.functionalMessage = functionalMessage;
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the id.
	 * 
	 * @return <code>id</code>.
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the id.
	 * 
	 * @param <code>id</code>.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the action.
	 * 
	 * @return <code>action</code>.
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the action.
	 * 
	 * @param <code>action</code>.
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the description.
	 * 
	 * @return <code>description</code>.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the description.
	 * 
	 * @param <code>description</code>.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the customerAccountInteractionRole.
	 * 
	 * @return <code>customerAccountInteractionRole</code>.
	 */
	public List<CustomerAccountInteractionRole> getCustomerAccountInteractionRole() {
		return customerAccountInteractionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the customerAccountInteractionRole.
	 * 
	 * @param <code>customerAccountInteractionRole</code>.
	 */
	public void setCustomerAccountInteractionRole(
			List<CustomerAccountInteractionRole> customerAccountInteractionRole) {
		this.customerAccountInteractionRole = customerAccountInteractionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the partyInteractionRole.
	 * 
	 * @return <code>partyInteractionRole</code>.
	 */
	public PartyInteractionRole getPartyInteractionRole() {
		return partyInteractionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the partyInteractionRole.
	 * 
	 * @param <code>partyInteractionRole</code>.
	 */
	public void setPartyInteractionRole(PartyInteractionRole partyInteractionRole) {
		this.partyInteractionRole = partyInteractionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the functionalMessage.
	 * 
	 * @return <code>functionalMessage</code>.
	 */
	public FunctionalMessage getFunctionalMessage() {
		return functionalMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the functionalMessage.
	 * 
	 * @param <code>functionalMessage</code>.
	 */
	public void setFunctionalMessage(FunctionalMessage functionalMessage) {
		this.functionalMessage = functionalMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the errorMessage.
	 * 
	 * @return <code>errorMessage</code>.
	 */
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the errorMessage.
	 * 
	 * @param <code>errorMessage</code>.
	 */
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}	
}
