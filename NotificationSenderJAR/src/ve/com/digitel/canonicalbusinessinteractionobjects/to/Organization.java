package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "organizationId", "name"  })
public class Organization implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 3766282948192864863L;
	
	/**
	 * Identificador de la entidad financiera.
	 */
	@XmlElement(required=false, nillable=false)
	private Integer organizationId;	
	
	/**
	 * Nombre de la entidad financiera.
	 */
	@XmlElement(required=true, nillable=false)
	private String name;	
	
	/**
	 * <p>Constructor default without parameters.
	 */		
	public Organization() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */
	public Organization(Integer organizationId, String name) {
		super();
		this.organizationId = organizationId;
		this.name = name;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the organizationId
	 * 
	 * @return <code>organizationId</code>.
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the organizationId.
	 * 
	 * @param <code>organizationId</code>.
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
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
}
