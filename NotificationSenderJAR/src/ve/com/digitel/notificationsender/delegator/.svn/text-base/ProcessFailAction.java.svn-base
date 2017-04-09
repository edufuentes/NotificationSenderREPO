package ve.com.digitel.notificationsender.delegator;

//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.EXCEPTION;
//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.EXCEPTION_CAUSE_CODE;
//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.EXCEPTION_CAUSE_MESSAGE;
//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.EXCEPTION_CODE;
//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.EXCEPTION_DESCRIPTION;
//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.EXCEPTION_TRACE;
//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.PRODUCT_ORDER;
//import static ve.com.digitel.subscriberbillingprovisioning.util.Key.RESPONSE;

import java.util.Map;

//import ve.com.digitel.canonicalbusinessinteractionobjects.to.ErrorMessage;
//import ve.com.digitel.canonicalbusinessinteractionobjects.to.FunctionalMessage;
//import ve.com.digitel.canonicalbusinessinteractionobjects.to.ProductOrder;
import ve.com.digitel.notificationsender.delegator.rules.AbstractAction;
import ve.com.digitel.notificationsender.to.response.NotificationSenderResponse;
import ve.com.digitel.notificationsender.util.AppProperties;
import ve.com.digitel.notificationsender.util.Key;
//import ve.com.digitel.notificationsender.util.ProductOrderItemMinimal;


public class ProcessFailAction extends AbstractAction {

	private static final long serialVersionUID = 3091757958148212823L;

	public ProcessFailAction(String name) {
		super(name);
	}
	
	public void init () {
		logger.info("Inicializando : " + this.getClass().getName());
	}

	@Override
	protected void doExecute(Map<Key, Object> context) {
		
//		ProductOrder productOrder = (ProductOrder)context.get(PRODUCT_ORDER);
//		
//		if (!(Boolean)context.get(EXCEPTION)) {
//			
//			ProductOrderItemMinimal.updateProductOrder(productOrder.getProductOrderItem(), 
//													   null,  
//													   new ErrorMessage((String)context.get(EXCEPTION_CODE), 
//																		(String)context.get(EXCEPTION_DESCRIPTION),
//																		(String)context.get(EXCEPTION_TRACE)));
//		} else {
//			
//			ProductOrderItemMinimal.updateProductOrder(productOrder.getProductOrderItem(), 
//					   								   new FunctionalMessage((String)context.get(EXCEPTION_CODE),
//					   										                 (String)context.get(EXCEPTION_DESCRIPTION),
//					   										                 (String)context.get(EXCEPTION_CAUSE_CODE),
//					   										                 (String)context.get(EXCEPTION_CAUSE_MESSAGE)),
//					   								   null);
//		}
//		
//		FunctionalMessage functionalMessage = new FunctionalMessage(
//				  AppProperties.getProperty("subscriberbilling.unsucessful.code"),
//	  			  AppProperties.getProperty("subscriberbilling.unsucessful.message"),
//				  null,
//				  null);
//		
//		context.put(RESPONSE, ProcessFailAction.getResponse(productOrder, functionalMessage));
		
	}
	
//	static public NotificationSenderResponse getResponse(ProductOrder productOrder, FunctionalMessage functionalMessage) {
	static public NotificationSenderResponse getResponse() {
		
		NotificationSenderResponse response = new NotificationSenderResponse();
		response.setMesanje("Hubo un error");
		
		return response;
		
	}

}
