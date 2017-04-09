package ve.com.digitel.notificationsender.to.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ve.com.digitel.canonicalbusinessinteractionobjects.to.CustomerOrder;


/**
 * Objeto que encapsula la información correspondiente a la entrada al servicio.
 * 
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"customerOrder"})
public class NotificationSenderRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * Constructor por defecto. 
	 */
	public NotificationSenderRequest() {
		super();
		
	}

	/**
	 * Constructor sobrecargado. 
	 */
	public NotificationSenderRequest(CustomerOrder customerOrder) {
		super();
		this.customerOrder = customerOrder;
	}


	/**
	 * Objeto que agrupa los datos asociados a un producto. 
	 */
	@XmlElement(required=true, nillable=false)
	private CustomerOrder customerOrder;



	/**
	 * @return the customerOrder
	 */
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}


	/**
	 * @param customerOrder the customerOrder to set
	 */
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}


}
