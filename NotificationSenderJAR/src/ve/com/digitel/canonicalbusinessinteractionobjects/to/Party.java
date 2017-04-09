package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "partyId", "name" })
public class Party implements Serializable {
	
	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 6948000053593472754L;

	/**
	 * Identificador.
	 */
	@XmlElement(required=false, nillable=false)
	private Integer partyId;	
	
	/**
	 * Nombre del canal.
	 */
	@XmlElement(required=true, nillable=false)
	private String name;


	/**
	 * <p>Constructor default without parameters.
	 */		
	public Party() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */	
	public Party(Integer partyId, String name) {
		super();
		this.partyId = partyId;
		this.name = name;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the partyId
	 * 
	 * @return <code>partyId</code>.
	 */	
	public Integer getPartyId() {
		return partyId;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the partyId.
	 * 
	 * @param <code>partyId</code>.
	 */
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
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
