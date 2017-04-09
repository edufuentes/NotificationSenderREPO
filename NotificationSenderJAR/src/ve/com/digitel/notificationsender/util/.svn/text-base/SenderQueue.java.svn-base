package ve.com.digitel.notificationsender.util;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;

public class SenderQueue {
	
	private static Logger logger = BSSIntLogger.getBSSIntLogger(SenderQueue.class);
	
	private Queue destination;
	
	private QueueConnectionFactory connectionFactory;
	
	private QueueConnection queueConnection;
	
	private Integer attempts;
	
	private Long waitTime;
	
	private Throwable loadError = null;
	
	public void setConnectionFactory(
			QueueConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	
	public void setDestination(Queue destination) {
		this.destination = destination;
	}

	public void setAttemptsCustom(String attempts) {
		this.attempts = Integer.valueOf(AppProperties.getProperty(attempts));
	}

	public void setWaitTimeCustom(String waitTime) {
		this.waitTime = Long.valueOf(AppProperties.getProperty(waitTime));
	}

	public SenderQueue() {
		super();
	}

	public void init() {

		try {
			
			logger.info("Inicializando contexto");
			
			logger.info("Queue: " + destination.getQueueName());
			
			queueConnection = connectionFactory.createQueueConnection();
			
			logger.info("Contexto Inicializado");
			
			loadError = null;
			
		} catch (Exception e) {
			loadError = e;
			logger.error("Error en inicializar contexto", e);
		}
	}
	
	public void destroy() {
		
		try {
		
			if (queueConnection != null) queueConnection.close();
		
		} catch (Exception e) {
			logger.error("Error finalizando contexto", e);
		}
		
	}

	public void execute(Serializable request) throws RemoteException {
		
		int intentos = 0;
		
		QueueSession session = null;
		
		try {
			
			do {
				
				if(loadError == null) {
					
					session = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
					
					QueueSender sender = session.createSender(destination);
					
					ObjectMessage objectMessage = session.createObjectMessage(request);
					
					sender.send(objectMessage);
					
					return;
					
				} else {
					Thread.sleep(waitTime);
					intentos++;
					logger.error("Intento " + intentos);
					init();
				}
				
			} while (intentos < attempts);
			
		} catch (Exception e) {
			loadError = e;
		} finally {
			
			try {
				if(session != null) session.close();

			} catch (JMSException e) {
				logger.warn("No se logro cerrar la sesion", e);
			}
			
		}
		
		throw new RemoteException("Error al invocar el servicio, no es posible establecer comunicacion", loadError);
		
	}
}