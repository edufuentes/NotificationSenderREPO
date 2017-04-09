
package ve.com.digitel.notificationsender.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ve.com.digitel.notificationsender.to.request.NotificationSenderRequest;

@XmlRootElement(name = "executeNotificationSenderService", namespace = "http://services.notificationsender.digitel.com.ve/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeNotificationSenderService", namespace = "http://services.notificationsender.digitel.com.ve/")
public class ExecuteNotificationSenderService {

    @XmlElement(name = "NotificationSenderRequest", namespace = "",required=true)
    private NotificationSenderRequest notificationSenderRequest;

    /**
     * 
     * @return
     *     returns NotificationSenderRequest
     */
    public NotificationSenderRequest getNotificationSenderRequest() {
        return this.notificationSenderRequest;
    }

    /**
     * 
     * @param notificationSenderRequest
     *     the value for the notificationSenderRequest property
     */
    public void setNotificationSenderRequest(NotificationSenderRequest notificationSenderRequest) {
        this.notificationSenderRequest = notificationSenderRequest;
    }

}
