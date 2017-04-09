package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "eMailAddress" })
public class EmailContact implements Serializable {

	/**	
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 7220372439655430309L;
	
	
	/**
	 * Correo electrónico.
	 */
	@XmlElement(required=true, nillable=false)
	private String eMailAddress;

	/**
	 * <p>Constructor default without parameters.
	 */	
	public EmailContact() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */	
	public EmailContact(String mailAddress) {
		super();
		eMailAddress = mailAddress;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the eMailAddress
	 * 
	 * @return <code>eMailAddress</code>.
	 */	
	public String getEMailAddress() {
		return eMailAddress;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the eMailAddress.
	 * 
	 * @param <code>eMailAddress</code>.
	 */
	public void setEMailAddress(String mailAddress) {
		eMailAddress = mailAddress;
	}

	
}
