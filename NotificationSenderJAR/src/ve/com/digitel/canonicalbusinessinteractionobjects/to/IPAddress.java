package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "networkNumber" })
public class IPAddress implements Serializable {
	
	/**	
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = -1712792934662622201L;
	
	/**
	 * Contiene la dirección IP.
	 */
	@XmlElement(required=true, nillable=false)
	private String networkNumber;
	
	/**
	 * <p>Constructor default without parameters.
	 */		
	public IPAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * <p>Constructor with parameters.
	 */	
	public IPAddress(String networkNumber) {
		super();
		this.networkNumber = networkNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the networkNumber
	 * 
	 * @return <code>networkNumber</code>.
	 */	
	public String getNetworkNumber() {
		return networkNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the networkNumber.
	 * 
	 * @param <code>networkNumber</code>.
	 */
	public void setNetworkNumber(String networkNumber) {
		this.networkNumber = networkNumber;
	}
}
