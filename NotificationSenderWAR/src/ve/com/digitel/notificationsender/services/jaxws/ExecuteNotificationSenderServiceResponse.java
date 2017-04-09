
package ve.com.digitel.notificationsender.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ve.com.digitel.notificationsender.to.response.NotificationSenderResponseACK;

@XmlRootElement(name = "executeNotificationSenderServiceResponse", namespace = "http://services.notificationsender.digitel.com.ve/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeNotificationSenderServiceResponse", namespace = "http://services.notificationsender.digitel.com.ve/")
public class ExecuteNotificationSenderServiceResponse {

    @XmlElement(name = "NotificationSenderResponse", namespace = "",required=true)
    private NotificationSenderResponseACK notificationSenderResponse;

    /**
     * 
     * @return
     *     returns NotificationSenderResponseACK
     */
    public NotificationSenderResponseACK getNotificationSenderResponse() {
        return this.notificationSenderResponse;
    }

    /**
     * 
     * @param notificationSenderResponse
     *     the value for the notificationSenderResponse property
     */
    public void setNotificationSenderResponse(NotificationSenderResponseACK notificationSenderResponse) {
        this.notificationSenderResponse = notificationSenderResponse;
    }

}
