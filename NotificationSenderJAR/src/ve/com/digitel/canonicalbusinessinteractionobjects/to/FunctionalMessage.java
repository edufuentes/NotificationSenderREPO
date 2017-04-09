package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "code", "message","causeCode","causeMessage" })
public class FunctionalMessage implements Serializable {
	
	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 2606235329302772406L;

	/**
	 * Código del mensaje funcional
	 */
	@XmlElement(required=true, nillable=false)
	private String code;
	
	/**
	 * Mensaje funcional
	 */
	@XmlElement(required=true, nillable=false)
	private String message;
	
	/**
	 * Código del mensaje funcional del servicio que generó la falla
	 */
	@XmlElement(required=false, nillable=false)
	private String causeCode;
	
	/**
	 * Mensaje funcional del servicio que generó la falla
	 */
	@XmlElement(required=false, nillable=false)
	private String causeMessage;
	
	/**
	 * <p>Constructor default without parameters.
	 */
	public FunctionalMessage() {
		super();
	}
	
	/**
	 * <p>Constructor with parameters.
	 */
	public FunctionalMessage(String code, String message, String causeCode,
			String causeMessage) {
		super();
		this.code = code;
		this.message = message;
		this.causeCode = causeCode;
		this.causeMessage = causeMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the functional message code.
	 * 
	 * @return <code>code</code>.
	 */
	public String getCode() {
		return code;
	}

	
	/**
	 * 
	 * <p>
	 * Method that sets the functional message code.
	 * 
	 * @param <code>code</code>.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the functional message.
	 * 
	 * @return <code>message</code>.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the functional message.
	 * 
	 * @param <code>message</code>.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the functional message code of the service that caused the failure.
	 * 
	 * @return <code>causeCode</code>.
	 */
	public String getCauseCode() {
		return causeCode;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the functional message code of the service that caused the failure.
	 * 
	 * @param <code>causeCode</code>.
	 */
	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}
	
	
	/**
	 * 
	 * <p>
	 * Method that returns the functional message of the service that caused the failure.
	 * 
	 * @return <code>causeMessage</code>.
	 */
	public String getCauseMessage() {
		return causeMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the functional message of the service that caused the failure.
	 * 
	 * @param <code>causeMessage</code>.
	 */
	public void setCauseMessage(String causeMessage) {
		this.causeMessage = causeMessage;
	}

}
