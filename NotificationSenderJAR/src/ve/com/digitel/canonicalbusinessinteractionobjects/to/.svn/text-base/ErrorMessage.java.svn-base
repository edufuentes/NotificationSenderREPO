package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "code", "message","trace" })
public class ErrorMessage implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 6192667075162587209L;

	/**
	 * Código del mensaje tecnico
	 */
	@XmlElement(required=true, nillable=false)
	private String code;
	
	/**
	 * Mensaje de error
	 */
	@XmlElement(required=true, nillable=false)
	private String message;
	
	/**
	 * Traza del mensaje de error
	 */
	@XmlElement(required=true, nillable=false)
	private String trace;
	
	/**
	 * <p>Constructor default without parameters.
	 */
	public ErrorMessage() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */
	public ErrorMessage(String code, String message, String trace) {
		super();
		this.code = code;
		this.message = message;
		this.trace = trace;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the technical error code.
	 * 
	 * @return <code>code</code>.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the error message code.
	 * 
	 * @param <code>code</code>.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the technical error message.
	 * 
	 * @return <code>message</code>.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * 
	 * <p>
	 * Method that sets the technical error message.
	 * 
	 * @param <code>message</code>.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 
	 * <p>
	 * Method that returns the trace of the technical error.
	 * 
	 * @return <code>trace</code>.
	 */
	public String getTrace() {
		return trace;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the trace of the technical error.
	 * 
	 * @param <code>trace</code>.
	 */
	public void setTrace(String trace) {
		this.trace = trace;
	}

}
