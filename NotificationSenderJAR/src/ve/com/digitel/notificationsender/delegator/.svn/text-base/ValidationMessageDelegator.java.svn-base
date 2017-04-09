package ve.com.digitel.notificationsender.delegator;


import static ve.com.digitel.notificationsender.util.Key.ACTION;
import static ve.com.digitel.notificationsender.util.Key.AFFILIATE;
import static ve.com.digitel.notificationsender.util.Key.AMOUNT;
import static ve.com.digitel.notificationsender.util.Key.BENEFICIARY;
import static ve.com.digitel.notificationsender.util.Key.CARD_NUMBER;
import static ve.com.digitel.notificationsender.util.Key.CODE_ERROR;
import static ve.com.digitel.notificationsender.util.Key.CODE_FUNCTIONAL;
import static ve.com.digitel.notificationsender.util.Key.CUSTOMER_ORDER;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION_CODE;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION_DESCRIPTION;
import static ve.com.digitel.notificationsender.util.Key.LISTEMAIL;
import static ve.com.digitel.notificationsender.util.Key.MESSAGE_ERROR;
import static ve.com.digitel.notificationsender.util.Key.MESSAGE_FUNCTIONAL;
import static ve.com.digitel.notificationsender.util.Key.ORDER_TYPE;
import static ve.com.digitel.notificationsender.util.Key.TYPE_CARD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerAccountInteractionRole;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerOrder;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.EmailContact;
import ve.com.digitel.canonicalbusinessinteractionobjects.to.PartyRole;
import ve.com.digitel.notificationsender.delegator.rules.AbstractRule;
import ve.com.digitel.notificationsender.exceptions.IErrorHandler;
import ve.com.digitel.notificationsender.util.AppProperties;
import ve.com.digitel.notificationsender.util.Key;

import com.thoughtworks.xstream.XStream;

public class ValidationMessageDelegator extends AbstractRule {

	private static final long serialVersionUID = 3694551418673235523L;
	
	@Autowired
	private IErrorHandler<Map<Key, Object>> errorHandler;
	
	@Autowired
	private XStream xStream;

	public ValidationMessageDelegator(String name) {
		super(name);
	}
	
	public void init() {
		logger.info("Inicializando : " + this.getClass().getName());
	}

	@Override
	protected boolean makeDecision(Map<Key, Object> context) {
		

		try {
			logger.info("Extrayendo datos de CustomerOrder");
			//NotificationSenderResquest request =  (NotificationSenderResquest)context.get(REQUEST);
			CustomerOrder customerOrder = (CustomerOrder)context.get(CUSTOMER_ORDER);
			
			//valida la entrada del mensaje y se es correcta lo manda al delegador de GetCache
			

			String beneficiary = null;
			String affiliate = null;
			List<String> listEmail = null;
			String codeFunctional = null;
			String messageFunctional = null;
			String codeError = null;
			String messageError = null;
			///
			String cardNumber = null;
			String typeCard = null;
			Double amount = null;
			///
			String action		=	"";
			String orderType	=	"";
			
			if(customerOrder.getCustomerOrderItem()  != null && customerOrder.getCustomerOrderItem().size() > 0 ){
				
				if(customerOrder.getCustomerOrderItem().get(0).getCustomerAccountInteractionRole() != null 
						&& customerOrder.getCustomerOrderItem().get(0).getCustomerAccountInteractionRole().size() > 0) {
					
					if(customerOrder.getCustomerOrderItem().get(0).getAction() != null && 
							customerOrder.getCustomerOrderItem().get(0).getAction().equalsIgnoreCase(AppProperties.getProperty("AFFILIATION_SERVICE"))){
						
						
						orderType	=	customerOrder.getCustomerOrderType();
						action		=	customerOrder.getCustomerOrderItem().get(0).getAction();
						
					}
					
					for (CustomerAccountInteractionRole customerAccountInteractionRole : 
						customerOrder.getCustomerOrderItem().get(0).getCustomerAccountInteractionRole()) {
						
						//@ID_CUSTOMER_BENEFICIARY
						if(customerAccountInteractionRole.getInteractionRole().equalsIgnoreCase(AppProperties.getProperty("BENEFICIARY"))
								&& customerAccountInteractionRole.getCustomerAccount().getId() != null){
							beneficiary = customerAccountInteractionRole.getCustomerAccount().getId();
							
							//tipo de tarjeta, numero de tarjeta y Monto del BENEFICIARY
							if(customerAccountInteractionRole.getCustomerAccount().getPayment() != null &&
									customerAccountInteractionRole.getCustomerAccount().getPayment().size() > 0){	
								if(customerOrder.getCustomerOrderType().equalsIgnoreCase(AppProperties.getProperty("BILL_PAYMENT"))  || // Pago de factura
										customerOrder.getCustomerOrderType().equalsIgnoreCase(AppProperties.getProperty("VIRTUAL_RECHARGE"))){//Recarga virtual																
									
									cardNumber = customerAccountInteractionRole.getCustomerAccount().getPayment().get(0).getCardPM().getCardNumber();									
									if(customerAccountInteractionRole.getCustomerAccount().getPayment().get(0).getCardPM().getPaymentMethodType().equalsIgnoreCase(AppProperties.getProperty("TRANSFORM_CREDIT"))){
										typeCard = AppProperties.getProperty(AppProperties.getProperty("TRANSFORM_CREDIT"));
									}else if(customerAccountInteractionRole.getCustomerAccount().getPayment().get(0).getCardPM().getPaymentMethodType().equalsIgnoreCase(AppProperties.getProperty("TRANSFORM_DEBIT"))){
										typeCard = AppProperties.getProperty(AppProperties.getProperty("TRANSFORM_DEBIT"));
									}
									
									amount = customerAccountInteractionRole.getCustomerAccount().getPayment().get(0).getAmount();

								}
							}
							
						}
						
						//@ID_CUSTOMER_AFFILIATE			
						if(customerAccountInteractionRole.getInteractionRole().equalsIgnoreCase(AppProperties.getProperty("AFFILIATE"))
								&& customerAccountInteractionRole.getCustomerAccount().getId() != null){
							affiliate = customerAccountInteractionRole.getCustomerAccount().getId();
							
							//tipo de tarjeta y numero de tarjeta del AFFILIATE
							if(customerAccountInteractionRole.getCustomerAccount().getCardPM() != null && 
									customerAccountInteractionRole.getCustomerAccount().getCardPM().size()  > 0){
									if(customerOrder.getCustomerOrderType().equalsIgnoreCase(AppProperties.getProperty("PAYMENT_METHOD")) && 
											(customerOrder.getCustomerOrderItem().get(0).getAction().equalsIgnoreCase(AppProperties.getProperty("DELETE")) ||//Eliminar Método de pago
											 customerOrder.getCustomerOrderItem().get(0).getAction().equalsIgnoreCase(AppProperties.getProperty("UPDATE")) || //Modificar Método de pago
											 customerOrder.getCustomerOrderItem().get(0).getAction().equalsIgnoreCase(AppProperties.getProperty("ADD")))){	//Afiliar Método de pago								
										
										
										if(customerAccountInteractionRole.getCustomerAccount().getCardPM().get(0).getPaymentMethodType().equalsIgnoreCase(AppProperties.getProperty("TRANSFORM_CREDIT"))){
											
											typeCard = AppProperties.getProperty(AppProperties.getProperty("TRANSFORM_CREDIT"));
										
										}else if(customerAccountInteractionRole.getCustomerAccount().getCardPM().get(0).getPaymentMethodType().equalsIgnoreCase(AppProperties.getProperty("TRANSFORM_DEBIT"))){
											
											typeCard = AppProperties.getProperty(AppProperties.getProperty("TRANSFORM_DEBIT"));
										
										}										
										cardNumber = customerAccountInteractionRole.getCustomerAccount().getCardPM().get(0).getCardNumber();																			
									}										
							}
							
						}
					}
					
				}
				
				//@EMAIL
				if(customerOrder.getCustomerOrderItem().get(0).getPartyInteractionRole() != null){
					if(customerOrder.getCustomerOrderItem().get(0).getPartyInteractionRole().getPartyRole().size() > 0){
						listEmail = new ArrayList<String>();
						
						List<PartyRole> listPartyRole = customerOrder.getCustomerOrderItem().get(0).getPartyInteractionRole().getPartyRole();
						
						for (Iterator<PartyRole> iterator = listPartyRole.iterator(); iterator.hasNext();) {
							PartyRole partyRole = (PartyRole) iterator.next();
							
							if(partyRole.getName().equalsIgnoreCase(AppProperties.getProperty("EMAIL")) && partyRole.getEmailContact() != null){						
								
								List<EmailContact> listEmailContact = partyRole.getEmailContact();
								
								for (Iterator<EmailContact> iterator2 = listEmailContact.iterator(); iterator2.hasNext();) {
									EmailContact emailContact = (EmailContact) iterator2.next();									
									listEmail.add(emailContact.getEMailAddress());	
								}													
							}
						}
						
					}
				}		
				
				
				
				
			}
			
			
		
			//@CODE_FUNTIONAL
			if(customerOrder.getFunctionalMessage() != null && customerOrder.getErrorMessage() == null ){				
				codeFunctional = customerOrder.getFunctionalMessage().getCode();
				messageFunctional = customerOrder.getFunctionalMessage().getMessage();
			}else if(customerOrder.getErrorMessage() != null && customerOrder.getFunctionalMessage() == null){
			//@CODE_ERROR
				codeError = customerOrder.getErrorMessage().getCode();
				messageError = customerOrder.getErrorMessage().getMessage();
			}else{				
				throw new Exception("Request Invalido no existe un FunctionalMessage ni un ErrorMessage para continuar con el proceso de notificacion.");							
			}

			
			context.put(BENEFICIARY, beneficiary == null ? null:beneficiary);
			context.put(AFFILIATE, affiliate == null ? null:affiliate);
			context.put(LISTEMAIL, listEmail == null ? null:listEmail);
			context.put(CODE_FUNCTIONAL, codeFunctional == null ? null:codeFunctional);
			context.put(MESSAGE_FUNCTIONAL, messageFunctional == null ? null:messageFunctional);
			context.put(CODE_ERROR, codeError == null ? null:codeError);
			context.put(MESSAGE_ERROR, messageError == null ? null:messageError);
			
			context.put(AMOUNT, amount == null ? null:amount);
			context.put(TYPE_CARD, typeCard == null ? null:typeCard);
			context.put(CARD_NUMBER, cardNumber == null ? null:cardNumber);
			
			context.put(ORDER_TYPE,	orderType);
			context.put(ACTION, 	action);
			
			logger.info("Finalizada extracción datos de CustomerOrder");
			
			return Boolean.TRUE;
			
		} catch (Exception e) {
			context.put (EXCEPTION, Boolean.FALSE);
			context.put (EXCEPTION_CODE, AppProperties.getProperty("ERROR_TEC_01"));
			context.put (EXCEPTION_DESCRIPTION, AppProperties.getProperty(AppProperties.getProperty("ERROR_TEC_01")));
			
			this.errorHandler.handler(e, context);
			
			return Boolean.FALSE;
		}
	}

}