package ve.com.digitel.notificationsender.handler;

import org.xml.sax.SAXParseException;

import com.sun.xml.ws.developer.ValidationErrorHandler;

/**
 * Manejador de los errores ocurridos en la recepcion del mensaje SOAP. 
 *
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6
 */
public class SchemaValidationErrorHandler extends ValidationErrorHandler{

	/**
	 * Mensaje de Advertencia.
	 */
	public static final String WARNING = "SchemaValidationWarning";
	
	/**
	 * Mensaje de Error.
	 */
	public static final String ERROR = "SchemaValidationError";
	
	/**
	 * Mensaje de Error Fatal.
	 */
	public static final String FATAL_ERROR = "SchemaValidationFatalError";

	/**
	 * Metodo que almacena mensaje de adevertencia.
	 * 
	 * @param exception
	 */
	public void warning(SAXParseException exception) {
		packet.invocationProperties.put(WARNING, exception);
		
	}

	
	/**
	 * Metodo que almacena mensaje de error.
	 * 
	 * @param exception
	 */
	public void error(SAXParseException exception) {
		packet.invocationProperties.put(ERROR, exception);
		
	}

	/**
	 * Metodo que almacena mensaje de error fatal.
	 * 
	 * @param exception
	 */
	public void fatalError(SAXParseException exception) {
		packet.invocationProperties.put(FATAL_ERROR, exception);
		
	}
}