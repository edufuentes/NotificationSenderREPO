package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "party","emailContact","iPAddress" })
public class PartyRole implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = -9094395848634347469L;

	/**
	 * Nombre del rol.
	 */
	@XmlElement(required=true, nillable=false)
	private String name;	
	
	/**
	 * Objeto que contiene la información asociada al rol.
	 */
	@XmlElement(required=false, nillable=false)
	private Party party;

	/**
	 * Correo electrónico.
	 */
	@XmlElement(required=true, nillable=false)
	private List<EmailContact>  emailContact;	
	
	/**
	 * Objeto que contiene la información de la dirección IP de la solicitud.
	 */
	@XmlElement(required=false, nillable=false)
	private List<IPAddress>  iPAddress;		
	
	
	/**
	 * <p>Constructor default without parameters.
	 */		
	public PartyRole() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */
	public PartyRole(String name, Party party,List<EmailContact> emailContact,List<IPAddress>  iPAddress) {
		super();
		this.name = name;
		this.party = party;
		this.emailContact= emailContact;
		this.iPAddress = iPAddress;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the name
	 * 
	 * @return <code>name</code>.
	 */	
	public String getName() {
		return name;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the name.
	 * 
	 * @param <code>name</code>.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the party
	 * 
	 * @return <code>party</code>.
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the party.
	 * 
	 * @param <code>party</code>.
	 */
	public void setParty(Party party) {
		this.party = party;
	}
	
	/**
	 * 
	 * <p>
	 * Method that returns the emailContact
	 * 
	 * @return <code>emailContact</code>.
	 */
	public List<EmailContact> getEmailContact() {
		return emailContact;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the emailContact.
	 * 
	 * @param <code>emailContact</code>.
	 */
	public void setEmailContact(List<EmailContact> emailContact) {
		this.emailContact = emailContact;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the iPAddress
	 * 
	 * @return <code>iPAddress</code>.
	 */
	public List<IPAddress> getIPAddress() {
		return iPAddress;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the iPAddress.
	 * 
	 * @param <code>iPAddress</code>.
	 */
	public void setIPAddress(List<IPAddress> address) {
		iPAddress = address;
	}
}
