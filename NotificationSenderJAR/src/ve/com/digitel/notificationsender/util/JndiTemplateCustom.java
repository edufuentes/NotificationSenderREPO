package ve.com.digitel.notificationsender.util;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.jndi.JndiTemplate;

import ve.com.digitel.bssint.log.BSSIntLogger;

public class JndiTemplateCustom extends JndiTemplate {
	
	private static Logger logger = BSSIntLogger.getBSSIntLogger(JndiTemplateCustom.class);
	
	public JndiTemplateCustom() {
		super();
	}
	
	public void init() {
		logger.info("Estableciendo enlace JDNI");
	}
	
	public void setEnvironmentCustom(Properties environment) {
		
		Properties environmentCustom = new Properties();

		for (Object key : environment.keySet()) {
			Object value = environment.get(key);
			environmentCustom.setProperty(key.toString(), AppProperties.getProperty(value.toString()));
			
			logger.info("Propiedad = " + key.toString() + " Valor = " + value.toString());
		}
		
		super.setEnvironment(environmentCustom);
	}

}
