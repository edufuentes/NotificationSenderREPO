package ve.com.digitel.notificationsender.delegator;

import static ve.com.digitel.notificationsender.util.Key.AFFILIATE;
import static ve.com.digitel.notificationsender.util.Key.BENEFICIARY;
import static ve.com.digitel.notificationsender.util.Key.CODE_FUNCTIONAL;
import static ve.com.digitel.notificationsender.util.Key.MESSAGE_FUNCTIONAL;
import static ve.com.digitel.notificationsender.util.Key.CODE_ERROR;
import static ve.com.digitel.notificationsender.util.Key.MESSAGE_ERROR;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION_CODE;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION_DESCRIPTION;
import static ve.com.digitel.notificationsender.util.Key.LISTEMAIL;
import static ve.com.digitel.notificationsender.util.Key.AMOUNT;
import static ve.com.digitel.notificationsender.util.Key.TYPE_CARD;
import static ve.com.digitel.notificationsender.util.Key.CARD_NUMBER;
import static ve.com.digitel.notificationsender.util.Key.ORDER_TYPE;
import static ve.com.digitel.notificationsender.util.Key.ACTION;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;

import ve.com.digitel.notificationmailsender.email.to.EmailTO;
import ve.com.digitel.notificationsender.delegator.rules.AbstractRule;
import ve.com.digitel.notificationsender.exceptions.IErrorHandler;
import ve.com.digitel.notificationsender.proxy.SMSSenderHttpPostProxy;
import ve.com.digitel.notificationsender.proxy.SMTPProxy;
import ve.com.digitel.notificationsender.util.AppProperties;
import ve.com.digitel.notificationsender.util.Key;
import ve.com.digitel.notificationsender.util.StructCache;
import ve.com.digitel.notificationsender.util.TemplateCache;

import com.thoughtworks.xstream.XStream;

public class ConsultGetCacheDelegator extends AbstractRule {

	private static final long serialVersionUID = 3694551418673235523L;

	private DateFormat formatter = new SimpleDateFormat(AppProperties.getProperty("TIME_FORMAT"));

	@Autowired
	private IErrorHandler<Map<Key, Object>> errorHandler;

	@Resource (name="mapTemplateCache")
	private Map<String, TemplateCache> mapTemplateCache;

	@Autowired
	private SMTPProxy smtpProxy;

	@Autowired
	private XStream xStream;

	@Autowired
	private SMSSenderHttpPostProxy senderHttpPostProxy;

	public ConsultGetCacheDelegator(String name) {
		super(name);
	}

	public void init() {
		logger.info("Inicializando : " + this.getClass().getName());
	}

	@Override
	protected boolean makeDecision(Map<Key, Object> context) {


		try {

			logger.info("Validando los datos con el Cache para enviar a los Proxys Sender's");

			//NotificationSenderResquest request =  (NotificationSenderResquest)context.get(REQUEST);
			//CustomerOrder customerOrder = (CustomerOrder)context.get(CUSTOMER_ORDER);

			String amount = null, typeCard = null,  cardNumber = null;

			String beneficiary = (String) context.get(BENEFICIARY);
			String affiliate = (String)  context.get(AFFILIATE);
			List<String> listEmail = (List<String>) context.get(LISTEMAIL);

			String codeFunctional = (String) context.get(CODE_FUNCTIONAL);
			String messageFunctional = (String) context.get(MESSAGE_FUNCTIONAL);
			String codeError  = (String) context.get(CODE_ERROR);	
			String messageError = (String) context.get(MESSAGE_ERROR);

			///

			if ((Double) context.get(AMOUNT) != null)
				amount =  String.valueOf(((Double) context.get(AMOUNT)).intValue());

			typeCard = (String) context.get(TYPE_CARD);
			cardNumber = (String) context.get(CARD_NUMBER);

			String	orderType	=	(String) context.get(ORDER_TYPE);
			String	action		=	(String) context.get(ACTION);

			StructCache structCache = null;
			TemplateCache templateCache = null;
			List<StructCache> listStructCache = null;

			Calendar cal = Calendar.getInstance();
			String fecha = formatter.format(cal.getTime());


			if(logger.isDebugEnabled())
				logger.debug("Fecha Actual: " + fecha ); 

			if(logger.isDebugEnabled()){
				logger.debug("Contenido del Cache: " + Arrays.toString(mapTemplateCache.keySet().toArray()));

				if(mapTemplateCache.keySet().contains(codeFunctional)){
					logger.debug("El cache contiente  el codigo Functional:  " + codeFunctional);
				}else if(mapTemplateCache.keySet().contains(codeError)){
					logger.debug("El cache contiente  el codigo Error:  " + codeError);
				}else{
					if(codeFunctional != null){
						logger.debug("El cache No contiente el codigo Functional: " + codeFunctional + " buscado");
					}else{
						logger.debug("El cache No contiente el codigo Error: " + codeError + " buscado");
					}
				}

			}

			if (mapTemplateCache.containsKey(codeFunctional) || mapTemplateCache.containsKey(codeError)){

				if(codeFunctional != null)
					templateCache = (TemplateCache) mapTemplateCache.get(codeFunctional);
				else if(codeError != null)
					templateCache = (TemplateCache) mapTemplateCache.get(codeError);

				listStructCache = templateCache.getListStructCache();
				if(logger.isDebugEnabled())
					logger.debug("size de listStructCache: " + listStructCache.size());

				for (Iterator<StructCache> iterator = listStructCache.iterator(); iterator.hasNext();) {
					structCache = (StructCache) iterator.next();

					Boolean sendMessage = true;

					if(structCache.getDestinatary() == null){// se envia lo recogido desde el request

						if(beneficiary  == null && affiliate == null && listEmail == null){

							logger.warn(" No se encontraron destinatarios ni en el Cache ni en el resquest entrante, para el codigo: " + templateCache.getCode());

						}else{
							if(structCache.getNoticeType().equalsIgnoreCase(AppProperties.getProperty("NOTICE_TYPE_SMS"))){ //enviar a SMSSender

								List<String> listGSM = new ArrayList<String>();

								listGSM.add(beneficiary == null? "": beneficiary);
								listGSM.add(affiliate == null? "": affiliate);

						
								String message = null;
								if(structCache.getMessage().contains(AppProperties.getProperty("TOKEN_MESSAGE"))){
									if(messageFunctional != null){
										message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageFunctional);
									}else if(messageError != null){
										message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageError);
									}
								}else{
									message = structCache.getMessage();
								}

								if(logger.isDebugEnabled()){
									logger.debug("Mensaje extraido de la BD: "  + message);
								}

								if(message.contains(AppProperties.getProperty("TOKEN_DATE"))){							
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_DATE"),fecha);
								}

								if(message.contains(AppProperties.getProperty("TOKEN_AMOUNT"))){
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_AMOUNT"),amount);
								}

								if(message.contains(AppProperties.getProperty("TOKEN_TYPE_CARD"))){
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_TYPE_CARD"),typeCard);
								}

								if(message.contains(AppProperties.getProperty("TOKEN_CARD_NUMBER"))){
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_CARD_NUMBER"),cardNumber);
								}
								
								if((action.equalsIgnoreCase(AppProperties.getProperty("AFFILIATION_SERVICE")))){
									if(!message.toUpperCase().contains(orderType.toUpperCase())){
										sendMessage = false;
									}
								}

								if(sendMessage){
									logger.info("Enviando SMS desde Request: " + Arrays.toString(listGSM.toArray()));
									senderHttpPostProxy.sendSMS(listGSM, message);
								}

							}else if(structCache.getNoticeType().equalsIgnoreCase(AppProperties.getProperty("NOTICE_TYPE_EMAIL"))){ //enviar a EmailSenser

								List<InternetAddress> listAddress = new ArrayList<InternetAddress>();

								for (Iterator<String> iterator_ = listEmail.iterator(); iterator_.hasNext();) {
									String email = (String) iterator_.next();
									listAddress.add(new InternetAddress(email));
								}

							

								EmailTO request = new EmailTO();
								request.setFrom(AppProperties.getProperty("MAIL_EMAIL_ADMIN"));						   
								request.setSubject(structCache.getSubject()); 
								request.setDate(Calendar.getInstance().getTime());

								String message = null;
								if(structCache.getMessage().contains(AppProperties.getProperty("TOKEN_MESSAGE"))){
									if(messageFunctional != null){
										message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageFunctional);
									}else if(messageError != null){
										message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageError);
									}
								}else{
									message = structCache.getMessage();
								}

								if(logger.isDebugEnabled()){
									logger.debug("Mensaje extraido de la BD: "  + message);
								}

								if(message.contains(AppProperties.getProperty("TOKEN_DATE"))){							
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_DATE"),fecha);
								}

								if(message.contains(AppProperties.getProperty("TOKEN_AMOUNT"))){
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_AMOUNT"),amount);
								}

								if(message.contains(AppProperties.getProperty("TOKEN_TYPE_CARD"))){
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_TYPE_CARD"),typeCard);
								}


								if(message.contains(AppProperties.getProperty("TOKEN_CARD_NUMBER"))){
									message = message.replaceFirst(AppProperties.getProperty("TOKEN_CARD_NUMBER"),cardNumber);
								}

								request.setData(message);

								if (logger.isDebugEnabled()) {
									logger.debug("Enviando mensaje: (" + message + ")" + " Remitente: " + AppProperties.getProperty("MAIL_EMAIL_ADMIN"));
								}

								if((action.equalsIgnoreCase(AppProperties.getProperty("AFFILIATION_SERVICE")))){
									if(!message.toUpperCase().contains(orderType.toUpperCase())){
										sendMessage = false;
									}
								}

								if(sendMessage){
									logger.info("Enviando Correo Electronio desde Request: " + Arrays.toString(listAddress.toArray()));
									smtpProxy.executeSendMessage(request, listAddress);
								}

							}
						}

					}else{ // se envia lo recogido desde el cache

						if(structCache.getNoticeType().equalsIgnoreCase(AppProperties.getProperty("NOTICE_TYPE_SMS"))){ //enviar a SMSSender

							String smsArray[] = structCache.getDestinatary().split(AppProperties.getProperty("SPLIT_SMS"));

							List<String> listGSM = new ArrayList<String>();

							for (int i = 0; i < smsArray.length; i++) {							
								listGSM.add(smsArray[i]);
							}

						
							String message = null;
							if(structCache.getMessage().contains(AppProperties.getProperty("TOKEN_MESSAGE"))){
								if(messageFunctional != null){
									message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageFunctional);
								}else if(messageError != null){
									message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageError);
								}
							}else{
								message = structCache.getMessage();
							}

							if(logger.isDebugEnabled()){
								logger.debug("Mensaje extraido de la BD: "  + message);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_DATE"))){							
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_DATE"),fecha);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_AMOUNT"))){
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_AMOUNT"),amount);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_TYPE_CARD"))){
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_TYPE_CARD"),typeCard);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_CARD_NUMBER"))){
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_CARD_NUMBER"),cardNumber);
							}

							if((action.equalsIgnoreCase(AppProperties.getProperty("AFFILIATION_SERVICE")))){
								if(!message.toUpperCase().contains(orderType.toUpperCase())){
									sendMessage = false;
								}
							}

							if(sendMessage){
								logger.info("Enviando SMS  desde Cache: " + Arrays.toString(listGSM.toArray()));
								senderHttpPostProxy.sendSMS(listGSM, message);
							}

						}else if(structCache.getNoticeType().equalsIgnoreCase(AppProperties.getProperty("NOTICE_TYPE_EMAIL"))){ //enviar a EmailSenser


							List<InternetAddress> listAddress = new ArrayList<InternetAddress>();

							String emailArray[] = structCache.getDestinatary().split(AppProperties.getProperty("SPLIT_EMAIL"));

							for (int i = 0; i < emailArray.length; i++) {							
								listAddress.add(new InternetAddress(emailArray[i]));
							}

						
							EmailTO request = new EmailTO();
							request.setFrom(AppProperties.getProperty("MAIL_EMAIL_ADMIN"));						   
							request.setSubject(structCache.getSubject()); 
							request.setDate(Calendar.getInstance().getTime());

							String message = null;
							if(structCache.getMessage().contains(AppProperties.getProperty("TOKEN_MESSAGE"))){
								if(messageFunctional != null){
									message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageFunctional);
								}else if(messageError != null){
									message = structCache.getMessage().replaceFirst(AppProperties.getProperty("TOKEN_MESSAGE"),messageError);
								}
							}else{
								message = structCache.getMessage();
							}

							if(logger.isDebugEnabled()){
								logger.debug("Mensaje extraido de la BD: "  + message);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_DATE"))){							
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_DATE"),fecha);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_AMOUNT"))){
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_AMOUNT"),amount);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_TYPE_CARD"))){
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_TYPE_CARD"),typeCard);
							}

							if(message.contains(AppProperties.getProperty("TOKEN_CARD_NUMBER"))){
								message = message.replaceFirst(AppProperties.getProperty("TOKEN_CARD_NUMBER"),cardNumber);
							}


							request.setData(message);

							if (logger.isDebugEnabled()) {
								logger.debug("Enviando mensaje: (" + structCache.getMessage() + ")" + "Remitente: " + AppProperties.getProperty("MAIL_EMAIL_ADMIN"));
							}
							
							if((action.equalsIgnoreCase(AppProperties.getProperty("AFFILIATION_SERVICE")))){
								if(!message.toUpperCase().contains(orderType.toUpperCase())){
									sendMessage = false;
								}
							}

							if(sendMessage){
								logger.info("Enviando Correo Electronio desde Cache: " + Arrays.toString(listAddress.toArray()));
								smtpProxy.executeSendMessage(request, listAddress);
							}
						}
					}	
				}


			}else{
				if(codeFunctional != null){
					logger.error("El cache No contiente el codigo Functional: " + codeFunctional + " buscado");
					throw new Exception("No existe en el Cache el codeFunctional:" +codeFunctional+ " buscado.");
				}else{
					logger.error("El cache No contiente el codigo Error: " + codeError + " buscado");
					throw new Exception("No existe en el Cache el codeError:" +codeFunctional+ " buscado.");
				}

			}

			logger.info("Finalizado exitosamente envio de " + structCache.getNoticeType());

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




