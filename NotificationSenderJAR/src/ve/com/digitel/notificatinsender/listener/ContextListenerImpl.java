package ve.com.digitel.notificatinsender.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationsender.util.AppProperties;




/**
 * Listener encargado de inicializar el contexto del Servicio.
 * 
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6
 */
public class ContextListenerImpl implements ServletContextListener {

	/**
	 * Instancia de Logger para el manejo de trazas.
	 */
    private static Logger logger = BSSIntLogger.getBSSIntLogger(ContextListenerImpl.class);
	
    /**
     * Elimina la carga del archivo properties.
     *
     * @param event ServletContextEvent
     */
    public void contextDestroyed(ServletContextEvent event) {
    	AppProperties .destroy();
    	
    	if (!AppProperties.isLoaded()){
    		logger.info("Se libero la carga del Archivo Properties de manera Exitosa");
    	} 
    }

	 /**
     * Realiza la carga del archivo properties.
     *
     * @param event ServletContextEvent
     */
    public void contextInitialized(ServletContextEvent event) {
    	
    	AppProperties.init();
    	
    	if (AppProperties.isLoaded()){
    		logger.info("Se realizo la carga del Archivo Properties de manera Exitosa");
    	} else {
			logger.error(AppProperties.getTrace());
		}
    }
}