package ve.com.digitel.notificationsender.handler;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ve.com.digitel.bssint.log.BSSIntLogger;


/**
 * Clase Encargada de Buscar los valores en el XML.
 *
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6
 */
public class SAXValidationErrorHandler extends DefaultHandler {

	/**
	 * Instancia de Logger para el manejo de trazas.
	 */
	private static Logger logger = BSSIntLogger.getBSSIntLogger(SAXValidationErrorHandler.class);


	/**
	 * Constructor por defecto.
	 */
	public SAXValidationErrorHandler() {
		super();
	}

	/**
	 * Metodo encargado de manejar los warning generados al parsear el xml.
	 *  
	 * @param SAXParseException Especifica la traza del error.
	 */
	public void warning(SAXParseException e) throws SAXException {
		super.warning(e);
		logger.info("Parseando XML - Warning: ".concat(e.getMessage()));
	}

	/**
	 * Metodo encargado de manejar los errores generados al parsear el xml.
	 *  
	 * @param SAXParseException Especifica la traza del error.
	 */
	public void fatalError(SAXParseException e) throws SAXException {
		super.fatalError(e);
		logger.error("Parseando XML - FatalError: ".concat(e.getMessage()));
	}

	/**
	 * Metodo encargado de manejar los errores generados al parsear el xml.
	 *  
	 * @param SAXParseException Especifica la traza del error.
	 */
	public void error(SAXParseException e) throws SAXException {
		super.error(e);
		logger.error("Parseando XML - Error: ".concat(e.getMessage()));
	}


	
}