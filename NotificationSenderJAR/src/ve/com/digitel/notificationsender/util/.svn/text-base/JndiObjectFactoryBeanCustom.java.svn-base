package ve.com.digitel.notificationsender.util;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.jndi.JndiObjectFactoryBean;

import ve.com.digitel.bssint.log.BSSIntLogger;

public class JndiObjectFactoryBeanCustom extends JndiObjectFactoryBean {
	
	private static Logger logger = BSSIntLogger.getBSSIntLogger(JndiObjectFactoryBeanCustom.class);
	
	public JndiObjectFactoryBeanCustom() {
		super(); 
	}
	
	public void setJndiNameCustom(String jndiName) {
		super.setJndiName(AppProperties.getProperty(jndiName));
	}
	
	public void init() {
		logger.info("Creando enlace al recurso " + super.getJndiName());
	}
	
	@Override
	public void afterPropertiesSet() throws IllegalArgumentException, NamingException {
		
		try {
			super.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			logger.error("Error iniciando Jndi", e);
			throw e;
		} catch (NamingException e) {
			logger.error("Error iniciando Jndi", e);
			throw e;
		}
		
	}

}