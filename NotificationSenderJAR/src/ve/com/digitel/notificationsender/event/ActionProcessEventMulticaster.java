package ve.com.digitel.notificationsender.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import ve.com.digitel.notificationsender.to.request.NotificationSenderRequest;


public class ActionProcessEventMulticaster extends SimpleApplicationEventMulticaster {
	
	public void execute(NotificationSenderRequest notificationSenderRequest) { 
		ApplicationEventImplement applicationEventImplement = new ApplicationEventImplement(this, notificationSenderRequest);
		multicastEvent(applicationEventImplement);
	}
	
	public void setListener(ApplicationListener<ApplicationEventImplement> listener) {
		addApplicationListener(listener);
    }

}