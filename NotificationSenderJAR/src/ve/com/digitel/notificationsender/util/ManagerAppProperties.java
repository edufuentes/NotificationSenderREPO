package ve.com.digitel.notificationsender.util;


import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;


public class ManagerAppProperties {

    private static Logger logger = BSSIntLogger.getBSSIntLogger(ManagerAppProperties.class);
    
    public void initialized() {
    	
    	AppProperties.init();
    	
    	if (AppProperties.isLoaded()){
    		logger.info("Se realizo la carga del Archivo Properties de manera Exitosa");
    	} else {
			logger.error(AppProperties.getTrace());
		}
    }
    
    public void destroyed() {
    	AppProperties.destroy();
    	
    	if (!AppProperties.isLoaded()){
    		logger.info("Se libero la carga del Archivo Properties de manera Exitosa");
    	}
    }

}