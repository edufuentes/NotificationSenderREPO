package ve.com.digitel.notificationsender.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.EnvironmentUtil;
import ve.com.digitel.bssint.log.BSSIntLogger;

/**
 * Encargada de leer los mensajes manejados por el WSServices desde un archivo XML utilizando el patron Singlenton.
 *
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6
 */
public class AppProperties  {

	/**
     * Instancia de Logger para el manejo de trazas.
     */
    private static Logger logger = BSSIntLogger.getBSSIntLogger(AppProperties.class);

    /**
     * Carga el Archivo de Configuracion de los mensajes manejados por el WebServices.
     */
    private static Properties prop = null;

    /**
     * Contiene la traza del error al cargar el archivo proeperties XML.
     */
    private static String trace = null;
    
    /**
     * Indica si se realiza la carga correctamente.
     */
    private static boolean loaded = false;

    /**
     * Funcion que se encarga de leer el archivo de propiedades.
     */
    public static void init() {
    	
        FileInputStream fis = null;
        
        try {
            prop = new Properties();
            fis = new FileInputStream(EnvironmentUtil.getAbsoluteResourceName("properties.xml"));
            prop.loadFromXML(fis);
            loaded = true;
        } catch (Exception e) {
        	trace = e.getMessage();
            logger.error(e);
            loaded = false;
        } finally {
        	try {
        		if(fis != null)
        			fis.close();
			} catch (IOException e) {
				logger.error("No se logro realizar el cierre del Archivo Properties despues de la carga");
			}
        }
    }

    /**
     * Funcion que se encarga de almacenar el archivo de propiedades.
     */
    public static void store() {
    	
    	FileOutputStream fos = null;
    	
        try {
        	fos = new FileOutputStream(EnvironmentUtil.getAbsoluteResourceName("properties.xml"));
            prop.storeToXML(fos, "Actualizacion de los atributos", "UTF-08");
            loaded = false;
        } catch (Exception e) {
        	trace = e.getMessage();
            logger.error(e);
            loaded = false;
        } finally {
        	if(fos != null){
        		try {
					fos.flush();
					fos.close();
				} catch (IOException e) {
					logger.error("No se logro realizar el cierre del Archivo properties.xml despues de almacenarlo");
				}
        	}
        }
    }
    
    /**
     * Funcion encargada de dado una clave consultar su valor.
     *
     * @param key Clave del valor a consultar.
     * @return Valor de la clave.
     */
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    /**
     * Metodo encargado de almacenar el valor de una clave.
     * 
     * @param key clave
     * @param value valor asociado a la clave.
     */
    public static void setProperty(String key, String value) {
        prop.setProperty(key, value);
    }
    
    /**
     * Funcion que evalua si se cargo el archivo de configuracion.
     *
     * @return Logico donde se indica si la carga se realizo de manera exitosa.
     */
    public static boolean isLoaded(){
        return loaded;
    }
    
    /**
     * Metodo que destruye el archivo de configuracion cargado en memoria.
     */
    public static void destroy(){
    	prop = null;
    	loaded = false;
    }
        
    /**
     * Funcion que retorna el error al momento de cargar el archivo properties.
     * 
     * @return Mensaje de Error.
     */
    public static String getTrace(){
    	return trace;
    }
}