package ve.com.digitel.notificationsender.to.response;

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
public class NotificationSenderResponseACK {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;
	
	

	/**
	 * Objeto que agrupa los datos asociados a un producto. 
	 */
	@XmlElement(required=true, nillable=false)
	private CustomerOrder customerOrder;



	/**
	 * Constructor por defecto. 
	 */
	public NotificationSenderResponseACK() {
		super();
	}


	/**
	 * Constructor sobrecargado. 
	 */
	public NotificationSenderResponseACK(CustomerOrder customerOrder) {
		super();
		this.customerOrder = customerOrder;
	}


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
