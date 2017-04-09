package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "organization" })
public class ThirdPartyPayeeAgency implements Serializable {
	
	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 7070014630317633981L;

	/**
	 * Nombre del rol.
	 */
	@XmlElement(required=true, nillable=false)
	private String name;
	
	/**
	 * Objeto que contiene la información asociada al rol.
	 */
	@XmlElement(required=true, nillable=false)	
	private Organization organization;

	/**
	 * <p>Constructor default without parameters.
	 */		
	public ThirdPartyPayeeAgency() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */
	public ThirdPartyPayeeAgency(String name, Organization organization) {
		super();
		this.name = name;
		this.organization = organization;
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
	 * Method that returns the organization
	 * 
	 * @return <code>organization</code>.
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the organization.
	 * 
	 * @param <code>organization</code>.
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}	
}
