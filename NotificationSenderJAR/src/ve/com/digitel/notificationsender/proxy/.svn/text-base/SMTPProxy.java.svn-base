package ve.com.digitel.notificationsender.proxy;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationmailsender.email.to.EmailTO;
import ve.com.digitel.notificationsender.util.AppProperties;


public class SMTPProxy {
	
	/**
	 * Instancia de Logger para el manejo de trazas.
	 */
	private static Logger logger = BSSIntLogger.getBSSIntLogger(SMTPProxy.class);
	
	/**
     * Identificador del Usuario para el envio de Email.
     */
    private String userName;

    /**
     * Clave del Usuario.
     */
    private String password;

    /**
     * Direccion del Servidor de Correo.
     */
    private String endPoint;

    /**
     * Puerto del Servidor de Correo.
     */
    private String port;
    
    /**
     * Mode de autenticacion
     */
    private String modeAuth;
    
    /**
     * Mode para Debug
     */
    private Boolean modeDebug;
    
    
    /**
     * Session para el envio de Email.
     */
    private Session session;
    
    /**
     * Retorna la clave del usuario.
     *
     * @return <code>password</code>.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la clave del usuario.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = AppProperties.getProperty(password);
    }

    /**
     * Retorna el identificador del usuario.
     *
     * @return  <code>username</code>.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param username
     */
    public void setUserName(String username) {
        this.userName = AppProperties.getProperty(username);
    }

    /**
     * Retorna la direccion del Servidor de Email.
     *
     * @return <code>url</code>.
     */
	public String getEndPoint() {
		return endPoint;
	}
	
    /**
     * Establece la direccion del Servidor de Email.
     *
     * @param url
     */
	public void setEndPoint(String endpoint) {
		this.endPoint =  AppProperties.getProperty(endpoint);
	}

	/**
     * Retorna el puerto del Servidor de Email.
     *
     * @return  <code>port</code>.
     */
    public String getPort() {
        return port;
    }

    /**
     * Establece el puerto del Servidor de Email.
     *
     * @param port
     */
    public void setPort(String port) {
        this.port = AppProperties.getProperty(port);
    }

	/**
	 * Retorna el mode de autenticacion
	 * @return <code>modeAuth</code>.
	 */
	public String getModeAuth() {
		return modeAuth;
	}

	/**
	 * Establece modo de autenticacion, modeAuth = "AUTH" cuando se requiere autenticacion en el servidor SMTP
	 * 
	 * @param modeAuth 
	 */
	public void setModeAuth(String modeAuth) {
		this.modeAuth = AppProperties.getProperty(modeAuth);
	}
	
	/**
	 * Retorna el modo en Debug
	 * @return  <code>modeDebug</code>.
	 */
	public Boolean getModeDebug() {
		return modeDebug;
	}

    
    /**
     * Clase para realizar la Validacion de Autenticacion.
     */
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getUserName(), getPassword());
        }
    }

	/**
	 * Constructor por Defecto.
	 */
	public SMTPProxy() {
		super();		
	}
	
	public void init(){

		if (AppProperties.isLoaded()) {
			
			modeDebug = Boolean.valueOf(AppProperties.getProperty("MAIL_DEBUG"));
			
			if(logger.isDebugEnabled()){
				logger.debug("Inicializando Contexto del SuspendPostpaidLineNotificationProxy");

				logger.debug("EndPoint: "  + 	getEndPoint());				
				logger.debug("Port: " + 	getPort());
				logger.debug("UserName: "+	getUserName());
				logger.debug("Password: " +  getPassword());
				logger.debug("modeAuth: " +  getModeAuth());
				logger.debug("modeDebug: " +  getModeDebug());
				
			}

			 Properties props = new Properties();

		        props.put("mail.smtp.host", getEndPoint());
		        props.put("mail.smtp.port", getPort());
		        props.put("mail.smtp.debug", "true");

			if(modeAuth.equals("AUTH")){
			    props.put("mail.smtp.user", getUserName());
			    props.put("mail.smtp.auth", "true");
		            Authenticator auth = new SMTPAuthenticator();
		            session = Session.getInstance(props, auth);
			} else {
		            session = Session.getDefaultInstance(props);
		        }
		        session.setDebug(getModeDebug());
		    

			logger.info("Session contra Servidor SMTP Inicializada");
				

		}
	}

	
	public Boolean executeSendMessage(EmailTO request, List<InternetAddress> listAddress) throws Exception {

		int attempts = Integer.valueOf(AppProperties.getProperty("PSMTP_ATTEMPTS"));
		long waitTime = Long.valueOf(AppProperties.getProperty("PSMTP_WAIT_TIME"));


		do {

			if(session != null){ 
				
				MimeMessage mensaje = new MimeMessage(session);
		        mensaje.setSubject(request.getSubject());
		        mensaje.setFrom(new InternetAddress(request.getFrom()));
		        
		        //mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(request.getTo()));
		        
		        mensaje.setContent(request.getData(), "text/html");
		        
		        Transport.send(mensaje,(InternetAddress[]) listAddress.toArray(new InternetAddress[listAddress.size()]));
		        
				attempts = -1;
			} else {
				Thread.sleep(waitTime);
				attempts--;
				init();
			}
		} while (attempts > 0);

		if (attempts == 0)
			throw new MessagingException("Error de Comunicacion, se han completado todos los reintentos para conectarse contra el Servidor");
		
		logger.info("Envio de Correo Satisfactorio");
		
		return true;
		
	}


}
