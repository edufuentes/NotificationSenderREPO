package ve.com.digitel.notificationsender.proxy;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationsender.util.AppProperties;

/**
 * Delegador encargado de realizar la conexion con el service Broker.
 *
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6
 */
public class SMSSenderHttpPostProxy {

	private static final long serialVersionUID = 3564608366766032683L;

	/**
	 * Instancia de Logger para el manejo de trazas.
	 */
	private static Logger logger = BSSIntLogger.getBSSIntLogger(SMSSenderHttpPostProxy.class);

	/**
	 * Encoding de la Peticion.
	 */
	private static final String ENCODING = "UTF-8";


	private SimpleDateFormat formatter = new SimpleDateFormat(AppProperties.getProperty("DATE_FORMAT_SMSSENDER"));

	/**
	 * Tipo de Mensaje a Enviar.
	 */
	private static final String TEXT_XML = "text/xml";

	/**
	 * Direccion Fisica del InstantLink.
	 */
	private String endPointURL;

	/**
	 * Tiempo de Espera de la peticion.
	 */
	private String timeOutSmsSender;

	/**
	 * Tiempo de Espera de la peticion.
	 */
	private String soTimeOutSmsSender;

	/**
	 *  Mensaje enviado al SMSSender
	 */
	private String smsMessageSender;

	/**
	 *  Objeto Metodo de Envio POST
	 */
	private HttpPost httppost;
	/**
	 *  Objeto HttpClient
	 */
	private HttpClient httpclient;



	/**
	 * @return the timeOutSmsSender
	 */
	public String getTimeOutSmsSender() {
		return timeOutSmsSender;
	}

	/**
	 * @param timeOutSmsSender the timeOutSmsSender to set
	 */
	public void setTimeOutSmsSender(String timeOutSmsSender) {
		this.timeOutSmsSender = AppProperties.getProperty(timeOutSmsSender);
	}

	/**
	 * @return the soTimeOutSmsSender
	 */
	public String getSoTimeOutSmsSender() {
		return soTimeOutSmsSender;
	}

	/**
	 * @param soTimeOutSmsSender the soTimeOutSmsSender to set
	 */
	public void setSoTimeOutSmsSender(String soTimeOutSmsSender) {
		this.soTimeOutSmsSender = AppProperties.getProperty(soTimeOutSmsSender);
	}

	/**
	 * @return the endPointURL
	 */
	public String getEndPointURL() {
		return endPointURL;
	}

	/**
	 * @param endPointURL the endPointURL to set
	 */
	public void setEndPointURL(String endPointURL) {
		this.endPointURL = AppProperties.getProperty(endPointURL); 
	}


	/**
	 * 
	 *  <p>Unique constructor with parameters.
	 *  
	 *  @param name Rule name.
	 * */
	public SMSSenderHttpPostProxy() {
		super ();
	}

	/**
	 * Inicializa el Contexto
	 */
	public void init(){

		if (AppProperties.isLoaded()) {

			if(logger.isDebugEnabled()){
				logger.debug("Inicializando Contexto del SuspendPostpaidLineNotificationProxy");

				logger.debug("endPointURL: "  + getEndPointURL());				
				logger.debug("timeOutSmsSender: "+	getTimeOutSmsSender());
				logger.debug("soTimeOutSmsSender: " +  getSoTimeOutSmsSender());


			}

			httppost = new HttpPost(getEndPointURL());

			httpclient = new DefaultHttpClient();
			//httpclient.getParams().setParameter("http.connection.timeout", new Integer(timeOutSmsSender));

			// The time it takes to open TCP connection.
			httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, new Integer(getTimeOutSmsSender()));

			// Timeout when server does not send data.
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, new Integer(getSoTimeOutSmsSender()));



			logger.info("Objeto HTTPCLIENT Inicializado");


		}
	}


	/** 
	 * Metodo encargado de realizar la invocacion al metodo: Deliver del Service Broker.
	 * 
	 */	
	public Boolean sendSMS(List<String> listGSM, String message) throws Exception {

		int attempts = Integer.valueOf(AppProperties.getProperty("ATTEMPS_HTTPPOST")); 
		long waitTime = Long.valueOf(AppProperties.getProperty("TIMEOUT_HTTPPOST"));

		for (Iterator<String> iterator = listGSM.iterator(); iterator.hasNext();) {
			String GSM = (String) iterator.next();
			
			if(GSM.length() == 11 & GSM.startsWith("0")){
				if(logger.isDebugEnabled())
					logger.debug("numero Invalido: " + GSM);
				
				GSM = GSM.replaceFirst("0","");
				
				if(logger.isDebugEnabled())
					logger.debug("cambiando numero: " + GSM + " nuevo length es: " + GSM.length());	
				
			}

			String sysDate = formatter.format(Calendar.getInstance().getTime());
			smsMessageSender = AppProperties.getProperty("REQUEST_SMS_SENDER");


			smsMessageSender = smsMessageSender.replace("TRACEID_VALUE", String.valueOf(MDC.get("traceid")));
			smsMessageSender = smsMessageSender.replace("SYSDATE1_VALUE", String.valueOf(sysDate.toString()));
			smsMessageSender = smsMessageSender.replace("SYSDATE2_VALUE", String.valueOf(sysDate.toString()));
			smsMessageSender = smsMessageSender.replace("MESSAGE_VALUE", message);


			smsMessageSender = smsMessageSender.replace("GSM_SUBSCRIBER_VALUE", GSM);

			StringEntity entity = new StringEntity(smsMessageSender,TEXT_XML,ENCODING);
			httppost.setEntity(entity);

			ResponseHandler<String> responseHandler = new BasicResponseHandler();


			do{

				if(httpclient != null){ 

					String responseBody = httpclient.execute(httppost, responseHandler);

					if(responseBody.contains(AppProperties.getProperty("RESPONSE_ACK"))){					
						attempts = -1;
						logger.info("Envio de SMS Satisfactorio para el numero: " + GSM);
					}else{
						attempts = -1;
						logger.error("Error en el SMSSender: ".concat(responseBody));
					}
				} else {
					Thread.sleep(waitTime); 
					attempts--;
					init();
				}

			}while (attempts > 0);	
			
		}

		if (attempts == 0)
			throw new HttpException("Error de Comunicacion, se han completado todos los reintentos para conectarse contra el Servidor");

		return true;

	}


	void destroy(){
		if(httpclient!=null)
			httpclient.getConnectionManager().shutdown();					
		if (logger.isDebugEnabled()) 
			logger.debug("Cerrada conexion de httpclient");

	}
	
	

}