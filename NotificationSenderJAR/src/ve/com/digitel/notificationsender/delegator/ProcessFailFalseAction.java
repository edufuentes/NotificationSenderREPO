package ve.com.digitel.notificationsender.delegator;

//import static ve.com.digitel.notificationsender.util.Key.PRODUCT_ORDER;
import static ve.com.digitel.notificationsender.util.Key.RESPONSE;

import java.util.Map;

//import ve.com.digitel.canonicalbusinessinteractionobjects.to.FunctionalMessage;
//import ve.com.digitel.canonicalbusinessinteractionobjects.to.ProductBundleItem;
//import ve.com.digitel.canonicalbusinessinteractionobjects.to.ProductOrder;
//import ve.com.digitel.canonicalbusinessinteractionobjects.to.ProductOrderItem;
import ve.com.digitel.notificationsender.delegator.rules.AbstractAction;
import ve.com.digitel.notificationsender.to.response.NotificationSenderResponse;
import ve.com.digitel.notificationsender.util.AppProperties;
import ve.com.digitel.notificationsender.util.Key;


public class ProcessFailFalseAction extends AbstractAction {

	private static final long serialVersionUID = 8004944510615995372L;

	public ProcessFailFalseAction(String name) {
		super(name);
	}
	
	public void init () {
		logger.info("Inicializando : " + this.getClass().getName());
	}

	@Override
	protected void doExecute(Map<Key, Object> context) {
		
//		ProductOrder productOrder = (ProductOrder)context.get(PRODUCT_ORDER);
//		
//		Boolean sucessfulPartial = ProcessFailFalseAction.completeProductOrder(productOrder);
//		
//		String code = "";
//		String message = "";
//		
//		if (sucessfulPartial) {
//			code = AppProperties.getProperty("subscriberbilling.sucessful.partial.code");
//			message = AppProperties.getProperty("subscriberbilling.sucessful.partial.message");
//		} else {
//			code = AppProperties.getProperty("subscriberbilling.unsucessful.code");
//			message = AppProperties.getProperty("subscriberbilling.unsucessful.message");			
//		}
//		
//		SubscriberBillingProvisioningResponse response = new SubscriberBillingProvisioningResponse();
//		response.setProductOrder(productOrder);
//		response.setFunctionalMessage(new FunctionalMessage(code, message, null, null));
//		
//		context.put(RESPONSE, response);
		
	}
	
//	static public boolean completeProductOrder(ProductOrder productOrder) {
//		
//		boolean sucessfulPartial = false;
//		
//		for (ProductOrderItem productOrderItem : productOrder.getProductOrderItem()) {
//			
//			if (productOrderItem.getCustomerProduct().getProductBundle() != null &&
//					productOrderItem.getCustomerProduct().getProductBundle().getProductBundleItem() != null &&
//					!productOrderItem.getCustomerProduct().getProductBundle().getProductBundleItem().isEmpty()) {
//				
//				boolean sucessful = false;
//				boolean unSucessful = false;
//				
//				for ( ProductBundleItem productBundleItem : 
//					productOrderItem.getCustomerProduct().getProductBundle().getProductBundleItem()) {
//					
//					if (productBundleItem.getFunctionalMessage() == null && productBundleItem.getErrorMessage() == null) {
//						
//						FunctionalMessage functionalMessage = 
//							new FunctionalMessage(AppProperties.getProperty("subscriberbilling.unprocessed.code"),
//												  AppProperties.getProperty("subscriberbilling.unprocessed.message"),
//												  null, null);
//						productBundleItem.setFunctionalMessage(functionalMessage);
//						
//					} else if(productBundleItem.getFunctionalMessage() != null) {
//						
//						if (productBundleItem.getFunctionalMessage().getCode().
//									equalsIgnoreCase(AppProperties.getProperty("subscriberbilling.sucessful.code"))) {
//							if (!sucessful) sucessful = true;
//						} else if (productBundleItem.getFunctionalMessage().getCode().
//								equalsIgnoreCase(AppProperties.getProperty("subscriberbilling.sucessful.partial.code"))) {
//							if (!sucessful) sucessful = true;
//							if (!unSucessful) unSucessful = true;
//						} else {
//							if (!unSucessful) unSucessful = true;
//						}
//					
//					} else if(productBundleItem.getErrorMessage() != null) {
//						if (!unSucessful) unSucessful = true;
//					}
//					
//				}
//				
//				if (unSucessful) {
//					
//					if (!sucessful) {
//						
//						FunctionalMessage functionalMessage = new FunctionalMessage(
//		  						  AppProperties.getProperty("subscriberbilling.unsucessful.code"),
//						  		  AppProperties.getProperty("subscriberbilling.unsucessful.message"),
//									  null,
//									  null);
//		    				
//		    			productOrderItem.setFunctionalMessage(functionalMessage);
//		    			productOrderItem.setErrorMessage(null);
//						
//					} else {
//						
//		    			FunctionalMessage functionalMessage = 
//							new FunctionalMessage(AppProperties.getProperty("subscriberbilling.sucessful.partial.code"),
//									  			  AppProperties.getProperty("subscriberbilling.sucessful.partial.message"),
//												  null,
//												  null);
//		    			
//		    			productOrderItem.setFunctionalMessage(functionalMessage);
//		    			productOrderItem.setErrorMessage(null);
//					}
//					
//				} else if (sucessful){
//					
//					if (!(productOrderItem.getFunctionalMessage() != null && 
//							!productOrderItem.getFunctionalMessage().getCode().
//								equalsIgnoreCase(AppProperties.getProperty("subscriberbilling.sucessful.code")))
//						|| productOrderItem.getErrorMessage() == null) {
//						
//		    			FunctionalMessage functionalMessage = 
//							new FunctionalMessage(AppProperties.getProperty("subscriberbilling.sucessful.code"),
//									  			  AppProperties.getProperty("subscriberbilling.sucessful.message"),
//												  null,
//												  null);
//		    			
//		    			productOrderItem.setFunctionalMessage(functionalMessage);
//						
//					}
//					
//				}
//				
//			}
//			
//			if (productOrderItem.getFunctionalMessage() == null && productOrderItem.getErrorMessage() == null) {
//				
//				FunctionalMessage functionalMessage = 
//					new FunctionalMessage(AppProperties.getProperty("subscriberbilling.unprocessed.code"),
//										  AppProperties.getProperty("subscriberbilling.unprocessed.message"),
//										  null, null);
//				productOrderItem.setFunctionalMessage(functionalMessage);
//				
//			} else if((productOrderItem.getFunctionalMessage() != null)) {
//				
//				if (productOrderItem.getFunctionalMessage().getCode().equalsIgnoreCase(AppProperties.getProperty("subscriberbilling.sucessful.code")) || 
//					productOrderItem.getFunctionalMessage().getCode().equalsIgnoreCase(AppProperties.getProperty("subscriberbilling.sucessful.partial.code"))) {
//					if (!sucessfulPartial) sucessfulPartial = true;
//				}
//				
//			}
//			
//		}
//		
//		return sucessfulPartial;
//	}

}
