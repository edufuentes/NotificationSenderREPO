package ve.com.digitel.notificationsender.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.xml.sax.SAXParseException;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerAccountInteractionRole;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerOrder;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerOrderItem;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.EmailContact;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.ErrorMessage;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.FunctionalMessage;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.PartyInteractionRole;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.PartyRole;
import ve.com.digitel.notificationsender.handler.SchemaValidationErrorHandler;
import ve.com.digitel.notificationsender.to.request.NotificationSenderRequest;
import ve.com.digitel.notificationsender.to.response.NotificationSenderResponseACK;
import ve.com.digitel.notificationsender.util.AppProperties;


import ve.com.digitel.notificationsender.util.SenderQueue;

import com.sun.xml.ws.developer.SchemaValidation;
import com.thoughtworks.xstream.XStream;



/**
 * El servicio SuspendPostpaidLineServiceImpl realiza el encolamiento JMS de la solicitud de Suspension de una linea PostPago
 * Esta clase representa la fachada SOAP para su funcion es recibir una solicitud proveniente de un canal y encolarla <br />
 *
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6
 */

@WebService(name="NotificationSenderServiceImplPortType", serviceName="NotificationSenderService", wsdlLocation="WEB-INF/wsdl/NotificationSenderService.wsdl")
@SchemaValidation(handler=SchemaValidationErrorHandler.class)
public class NotificationSenderServiceImpl {
	
	/**
	 * Referencia al logger encargado de registrar las transacciones en la bitácora de la aplicación.
	 */
	private static Logger logger = BSSIntLogger.getBSSIntLogger(NotificationSenderServiceImpl.class);
	/**
	 * Obtiene el Contexto de los Errores Encontrados con la Validacion del XSD.
	 */
	@Resource
	private WebServiceContext wsContext;
	
	
	@WebMethod
	public @WebResult(name="NotificationSenderResponse")NotificationSenderResponseACK executeNotificationSenderService(@WebParam(name="NotificationSenderRequest")NotificationSenderRequest request){
		MDC.put("traceid", request.getCustomerOrder().getId());
		logger.info("Iniciando invocacion del Servicio: NotificationSenderService");

		NotificationSenderResponseACK responseACK = null;
		XStream stream = new XStream();

		if( logger.isDebugEnabled() ) {
			stream.alias("NotificationSenderRequest", NotificationSenderRequest.class);
			
			//stream.aliasAttribute(CustomerOrder.class, "id", "ID");
			
			stream.addImplicitCollection(CustomerOrder.class,"customerOrderItem","customerOrderItem",CustomerOrderItem.class);						
			stream.addImplicitCollection(PartyInteractionRole.class,"partyRole","partyRole",PartyRole.class);
			
			String requestText = stream.toXML(request);
			logger.debug("Request Entrada: " + requestText);
		}
		
		
		if(AppProperties.isLoaded()){
			MessageContext messageContext = wsContext.getMessageContext();
			// Validacion del Mensaje SOAP de Entrada
			SAXParseException errorException = (SAXParseException) messageContext.get(SchemaValidationErrorHandler.ERROR);
			SAXParseException fatalErrorException = (SAXParseException) messageContext.get(SchemaValidationErrorHandler.FATAL_ERROR);

			if(!IsValidRequest(request)){
				String codError = AppProperties.getProperty("ERROR_FUN_01");
				String msgError = AppProperties.getProperty(codError);
				
				String causeMessage; 				
				causeMessage = "Request invalido falta un objeto FunctionalMessage o ErrorMessage para procesar la solicitud.";
				
				logger.error(codError.concat("|").concat(msgError), errorException != null ?  errorException : fatalErrorException);
				
				responseACK = new NotificationSenderResponseACK(new CustomerOrder(new FunctionalMessage(codError, AppProperties.getProperty(codError), causeMessage , null),null));
				
			}else if (errorException != null || fatalErrorException != null ){
				String codError = AppProperties.getProperty("ERROR_FUN_01");
				String msgError = AppProperties.getProperty(codError);

				String causeMessage; 	
				
				causeMessage = errorException != null ?  errorException.getMessage() : fatalErrorException.getMessage();
										
				logger.error(codError.concat("|").concat(msgError), errorException != null ?  errorException : fatalErrorException);
				
				//responseACK = new SuspendPostpaidLineServiceResponse(request.getCustomerOrder(), new FunctionalMessage(codError, AppProperties.getProperty(codError), causeMessage.substring(0, causeMessage.indexOf(":")).trim() , causeMessage.substring(causeMessage.indexOf(":") + 1).trim()),null);

				responseACK = new NotificationSenderResponseACK(new CustomerOrder(new FunctionalMessage(codError, AppProperties.getProperty(codError), causeMessage.substring(0, causeMessage.indexOf(":")).trim() , causeMessage.substring(causeMessage.indexOf(":") + 1).trim()),null));
				
			}else if(isRequiredAttributeBPOrVP(request)){
				
				String codError = AppProperties.getProperty("ERROR_FUN_01");
				String msgError = AppProperties.getProperty(codError);
				
				String causeMessage; 				
				causeMessage = "Request invalido falta un objeto CardPM.";
				
				logger.error(codError.concat("|").concat(msgError), errorException != null ?  errorException : fatalErrorException);
				
				responseACK = new NotificationSenderResponseACK(new CustomerOrder(new FunctionalMessage(codError, AppProperties.getProperty(codError), causeMessage , null),null));				
			}else{

				try{
					
					WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)messageContext.get(MessageContext.SERVLET_CONTEXT)).getBean(SenderQueue.class).execute(request);
					
					CustomerOrder customerOrder = new CustomerOrder();
					customerOrder.setFunctionalMessage(new FunctionalMessage(AppProperties.getProperty("ERROR_FUN_05"),AppProperties.getProperty(AppProperties.getProperty("ERROR_FUN_05")),null,null));
					responseACK = new NotificationSenderResponseACK(customerOrder);//ACK exitoso
					
				}catch (Exception e) {
					String codError = AppProperties.getProperty("ERROR_TEC_01"); // Error de ejecucion
					String msgError = AppProperties.getProperty(codError);  // 				
					//responseACK = new SuspendPostpaidLineServiceResponse(request.getCustomerOrder(),null,new ErrorMessage(codError,msgError,null));
					responseACK = new NotificationSenderResponseACK(new CustomerOrder(null,new ErrorMessage(codError, msgError, null)));
					
					logger.error(codError.concat("|").concat(msgError), e);
				}
				
				
			}	

		}else{
			//responseACK =  new SuspendPostpaidLineServiceResponse(null,null,new ErrorMessage("IS-AEI-31-02-EM0003", "Error de ejecucion", AppProperties.getTrace()));
			responseACK = new NotificationSenderResponseACK(new CustomerOrder(null,new ErrorMessage("BCRM-03003-EM0003", "Error de ejecucion", AppProperties.getTrace())));
		
		}
		

		if( logger.isDebugEnabled() ) {
			
			
			stream.alias("NotificationSenderResponseACK", NotificationSenderResponseACK.class);
			
			String responseText = stream.toXML(responseACK);
			logger.debug("Response Salida: " + responseText);
		}
		
		logger.info("Finalizando ejecucion del Servicio: NotificationSenderService");
		MDC.remove("traceid");	
		return responseACK;
		
	}
	
	
	private Boolean IsValidRequest(NotificationSenderRequest notificationSenderResquest){
		
		if(logger.isDebugEnabled())
			logger.debug("Validando Request");
			
		if(notificationSenderResquest != null && notificationSenderResquest.getCustomerOrder() != null){			
				if(notificationSenderResquest.getCustomerOrder().getFunctionalMessage() == null && notificationSenderResquest.getCustomerOrder().getErrorMessage() == null){		
					if(logger.isDebugEnabled())
						logger.debug("Request invalido falta un objeto FunctionalMessage o ErrorMessage para procesar la solicitud. ");					
					return false;					
				}
		}else{			
			if(logger.isDebugEnabled())
				logger.debug("Request invalido");					
			return false;								
		}
		
		
		return true;
	}
	
	
	/**
	 * 
	 * @param request
	 * @return  Si retorna true es por que es requerido un atributo que no fue encontrado
	 */
	private Boolean isRequiredAttributeBPOrVP(NotificationSenderRequest request){
		
		CustomerOrder customerOrder = request.getCustomerOrder();
		
		if(customerOrder.getCustomerOrderItem()  != null && customerOrder.getCustomerOrderItem().size() > 0 ){
			
			if(customerOrder.getCustomerOrderItem().get(0).getCustomerAccountInteractionRole() != null 
					&& customerOrder.getCustomerOrderItem().get(0).getCustomerAccountInteractionRole().size() > 0) {
				
				for (CustomerAccountInteractionRole customerAccountInteractionRole : 
					customerOrder.getCustomerOrderItem().get(0).getCustomerAccountInteractionRole()) {
					
					//@ID_CUSTOMER_BENEFICIARY
					if(customerAccountInteractionRole.getInteractionRole().equalsIgnoreCase(AppProperties.getProperty("BENEFICIARY"))
							&& customerAccountInteractionRole.getCustomerAccount().getId() != null){
					
						//tipo de tarjeta, numero de tarjeta y Monto del BENEFICIARY
						if(customerAccountInteractionRole.getCustomerAccount().getPayment() != null &&
								customerAccountInteractionRole.getCustomerAccount().getPayment().size() > 0){	
							if(customerOrder.getCustomerOrderType().equalsIgnoreCase(AppProperties.getProperty("BILL_PAYMENT"))  || // Pago de factura
									customerOrder.getCustomerOrderType().equalsIgnoreCase(AppProperties.getProperty("VIRTUAL_RECHARGE"))){//Recarga virtual																
								
								if(customerAccountInteractionRole.getCustomerAccount().getPayment().get(0).getAmount() != null && customerAccountInteractionRole.getCustomerAccount().getPayment().get(0).getCardPM() == null){																		
										logger.error("Para el " + customerAccountInteractionRole.getInteractionRole() + " con la Operacion: " + customerOrder.getCustomerOrderType() +  " Requiere el objeto CardPM en el Request. ");					
									return true;	
									
								}
							}
						}
						
					//@ID_CUSTOMER_AFFILIATE -  PaymentMethod	
					}else if(customerAccountInteractionRole.getInteractionRole().equalsIgnoreCase(AppProperties.getProperty("AFFILIATE"))
								&& customerAccountInteractionRole.getCustomerAccount().getId() != null){
						
						//tipo de tarjeta, numero de tarjeta  AFFILIATE
						if((customerAccountInteractionRole.getCustomerAccount().getCardPM() == null &&
								customerOrder.getCustomerOrderType().equalsIgnoreCase(AppProperties.getProperty("PAYMENT_METHOD")))){ //Afiliacion de Metodo de Pago
							logger.error("Para el " + customerAccountInteractionRole.getInteractionRole() + " con la Operacion: " + customerOrder.getCustomerOrderType() +  " Requiere el objeto CardPM en el Request. ");					
							return true;

						}
					}

				}				
			}	
			
		}
		
		return false;
	}
	
	
	
	
	
}
