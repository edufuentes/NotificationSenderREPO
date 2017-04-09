package ve.com.digitel.notificationsender.event;

import org.springframework.context.ApplicationEvent;

import ve.com.digitel.notificationsender.to.request.NotificationSenderRequest;




public class ApplicationEventImplement extends ApplicationEvent {

	private static final long serialVersionUID = -8904528281406972809L;
	
	private NotificationSenderRequest notificationSenderRequest;

	
	public ApplicationEventImplement(Object source, NotificationSenderRequest notificationSenderRequest) {
		super(source);
		setNotificationSenderRequest(notificationSenderRequest);
	}


	/**
	 * @return the notificationSenderResquest
	 */
	public NotificationSenderRequest getNotificationSenderRequest() {
		return notificationSenderRequest;
	}


	/**
	 * @param notificationSenderResquest the notificationSenderResquest to set
	 */
	public void setNotificationSenderRequest(NotificationSenderRequest notificationSenderRequest) {
		this.notificationSenderRequest = notificationSenderRequest;
	}

	

	
	
}
