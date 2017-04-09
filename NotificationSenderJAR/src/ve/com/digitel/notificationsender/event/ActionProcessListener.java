package ve.com.digitel.notificationsender.event;

import static ve.com.digitel.notificationsender.util.Key.CUSTOMER_ORDER;
import static ve.com.digitel.notificationsender.util.Key.REQUEST;
//import static ve.com.digitel.notificationsender.util.Key.RESPONSE;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerOrder;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerOrderItem;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.PartyInteractionRole;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.PartyRole;
import ve.com.digitel.notificationsender.delegator.rules.AbstractComponent;
import ve.com.digitel.notificationsender.to.request.NotificationSenderRequest;
import ve.com.digitel.notificationsender.util.Key;
//import ve.com.digitel.subscriberbillingprovisioning.to.response.SubscriberBillingProvisioningResponse;
//import ve.com.digitel.subscriberbillingprovisioning.util.Key;
//import ve.com.digitel.subscriberbillingprovisioning.util.queue.SalePostSaleOrderProcessQueueBean;

import com.thoughtworks.xstream.XStream;

public class ActionProcessListener implements ApplicationListener<ApplicationEventImplement> {

	private static Logger logger = BSSIntLogger.getBSSIntLogger(ActionProcessListener.class);
	
	private AbstractComponent delegator = null;
	
	@Autowired
	private XStream xStream;
	
	public AbstractComponent getDelegator() {
		return delegator;
	}

	public void setDelegator(AbstractComponent delegator) {
		this.delegator = delegator;
	}

	@Override
	public void onApplicationEvent(ApplicationEventImplement applicationEvent) {
		MDC.put("traceid", applicationEvent.getNotificationSenderRequest().getCustomerOrder().getId());

		
		logger.info("Llamando al manejador de negocio");
		
		//Se llama al primer delegador del applicationContextDelegator.xml
		
		Map<Key, Object> context = new HashMap<Key, Object>();
		
		context.put(REQUEST, applicationEvent.getNotificationSenderRequest());
		context.put(CUSTOMER_ORDER, applicationEvent.getNotificationSenderRequest().getCustomerOrder());
		
		
		
		if( logger.isDebugEnabled() ) {
			xStream.alias("NotificationSenderRequest", NotificationSenderRequest.class);
			
			//stream.aliasAttribute(CustomerOrder.class, "id", "ID");
			
			xStream.addImplicitCollection(CustomerOrder.class,"customerOrderItem","customerOrderItem",CustomerOrderItem.class);						
			xStream.addImplicitCollection(PartyInteractionRole.class,"partyRole","partyRole",PartyRole.class);
			
			String requestText = xStream.toXML(applicationEvent.getNotificationSenderRequest());
			logger.debug("Request Entrada en ActionProcessListener: " +  System.getProperty("line.separator") + requestText);
		}
			
		
		delegator.execute(context);
		
		
		
		logger.info("Finalizada la llamada al manejador de negocio");
		MDC.remove("traceid");
		
	}

}
