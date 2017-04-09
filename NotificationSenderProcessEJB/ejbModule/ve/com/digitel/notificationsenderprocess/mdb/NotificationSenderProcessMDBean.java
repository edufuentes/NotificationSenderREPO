package ve.com.digitel.notificationsenderprocess.mdb;

import static ve.com.digitel.notificationsender.util.Utils.LOCATOR_FACTORY_SELECTOR;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.ejb.support.AbstractMessageDrivenBean;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationsender.event.ActionProcessEventMulticaster;
import ve.com.digitel.notificationsender.to.request.NotificationSenderRequest;




@MessageDriven(mappedName="notificationsenderprocess.jms.queue", activationConfig = {
		@ActivationConfigProperty(propertyName = "connection-factory-jndi-name", propertyValue = "notificationsenderprocess.jms.factory"),
		@ActivationConfigProperty(propertyName = "destinationType", 			 propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", 			 propertyValue = "Auto-acknowledge")
})
public class NotificationSenderProcessMDBean extends AbstractMessageDrivenBean implements MessageListener {

	private static final long serialVersionUID = 4505904140892699911L;

	/**
	 * Objeto para ejecución de trazas
	 */
	private static Logger logger = BSSIntLogger.getBSSIntLogger(NotificationSenderProcessMDBean.class);

	public NotificationSenderProcessMDBean(){		
		super();
	}
	
	
	@Override
	public void setMessageDrivenContext(MessageDrivenContext messageDrivenContext) throws EJBException {
		super.setMessageDrivenContext(messageDrivenContext);
		setBeanFactoryLocator(ContextSingletonBeanFactoryLocator.getInstance(LOCATOR_FACTORY_SELECTOR.toString()));
	    setBeanFactoryLocatorKey("beanFactory");
	}

	@Override
	public void ejbRemove() throws EJBException {
		super.setMessageDrivenContext(null);
		logger.info("Remueve MDB " + this.getClass().getName());
	}
	
	@Override
	protected void onEjbCreate() {
		logger.info("Creando MDB " + this.getClass().getName());
	}
	
	@Override
	public void ejbCreate() {
		super.ejbCreate();
	}


	@Override
	public void onMessage(Message message) {
		
		
		
		try {

				Object obj = ((ObjectMessage) message).getObject();
				NotificationSenderRequest request = (NotificationSenderRequest)obj;
				MDC.put("traceid", request.getCustomerOrder().getId());
				
				logger.info("Llegando mensaje: " + request.getCustomerOrder().getId());
				
				getBeanFactory().getBean(ActionProcessEventMulticaster.class).execute(request);				

		} catch (Exception e) {
			logger.error("Error Obteniendo mensaje de la cola ", e);
		} finally {
			logger.info("Finalizado la recepcion del mensaje" + this.getClass().getName());
		}
		
		MDC.remove("traceid");
	}
}
