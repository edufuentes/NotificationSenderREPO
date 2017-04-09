package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "partyRole", "interactionRole" })
public class PartyInteractionRole implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = -3138177668680192005L;
	
	/**
	 * Objeto que contiene la información del canal.
	 */
	@XmlElement(required=true, nillable=false)
	private List<PartyRole> partyRole;	
	
	/**
	 * Rol del Sistema.
	 */
	@XmlElement(required=false, nillable=false)
	private String interactionRole;


	/**
	 * <p>Constructor default without parameters.
	 */	
	public PartyInteractionRole() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */
	public PartyInteractionRole(List<PartyRole> partyRole, String interactionRole) {
		super();
		this.partyRole = partyRole;
		this.interactionRole = interactionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the partyRole
	 * 
	 * @return <code>partyRole</code>.
	 */	
	public List<PartyRole> getPartyRole() {
		return partyRole;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the partyRole.
	 * 
	 * @param <code>partyRole</code>.
	 */
	public void setPartyRole(List<PartyRole> partyRole) {
		this.partyRole = partyRole;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the interactionRole
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
}
