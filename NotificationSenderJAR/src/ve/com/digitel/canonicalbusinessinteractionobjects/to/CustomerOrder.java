package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "orderItemNumber", "customerOrderType","customerOrderStatus","purchaseOrderNumber","interactionDate","description","customerOrderItem","partyInteractionRole","functionalMessage","errorMessage" })
public class CustomerOrder implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 2335118363928441105L;
	
	/**
	 * Identificador de la orden.
	 */	
	@XmlElement(required=true, nillable=false)
	private String id;	
	
	/**
	 * Índice que identifica la orden.
	 */	
	@XmlElement(required=false, nillable=false)
	private BigDecimal orderItemNumber;
	
	/**
	 * Tipo de orden.
	 */			
	@XmlElement(required=false, nillable=false)
	private String customerOrderType;	
	
	/**
	 * Estado de la orden.
	 */			
	@XmlElement(required=false, nillable=false)
	private String customerOrderStatus;

	/**
	 * Número de pedido.
	 */	
	@XmlElement(required=false, nillable=false)
	private String purchaseOrderNumber;
	
	/**
	 * Fecha del pedido.
	 */		
	@XmlElement(required=false, nillable=false)
	private Calendar interactionDate;	
	
	/**
	 * Descripción.
	 */		
	@XmlElement(required=false, nillable=false)
	private String description;
	
	/**
	 * Objeto que agrupa los datos asociados a un producto.
	 */		
	@XmlElement(required=false, nillable=false)
	private List<CustomerOrderItem> customerOrderItem;	
	
	/**
	 * Objeto que contiene la información del canal.
	 */		
	@XmlElement(required=false, nillable=false)
	private PartyInteractionRole partyInteractionRole;

	/**
	 * Objeto que contiene la información del mensaje funcional que retorna el servicio.
	 */		
	@XmlElement(required=false, nillable=false)
	private FunctionalMessage functionalMessage;	
	
	/**
	 * Objeto que contiene la información del mensaje de error técnico que retorna el servicio.
	 */		
	@XmlElement(required=false, nillable=false)
	private ErrorMessage errorMessage;

	/**
	 * <p>Constructor default without parameters.
	 */	
	public CustomerOrder() {
		super();

	}

	/**
	 * <p>Constructor with parameters.
	 */
	public CustomerOrder(String id, BigDecimal orderItemNumber,
			String customerOrderType, String customerOrderStatus,
			String purchaseOrderNumber, Calendar interactionDate,
			String description, List<CustomerOrderItem> customerOrderItem,
			PartyInteractionRole partyInteractionRole,
			FunctionalMessage functionalMessage, ErrorMessage errorMessage) {
		super();
		this.id = id;
		this.orderItemNumber = orderItemNumber;
		this.customerOrderType = customerOrderType;
		this.customerOrderStatus = customerOrderStatus;
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.interactionDate = interactionDate;
		this.description = description;
		this.customerOrderItem = customerOrderItem;
		this.partyInteractionRole = partyInteractionRole;
		this.functionalMessage = functionalMessage;
		this.errorMessage = errorMessage;
	}

	
	
	
	
	
	/**
	 * @param functionalMessage
	 * @param errorMessage
	 */
	public CustomerOrder(FunctionalMessage functionalMessage, ErrorMessage errorMessage) {
		super();
		this.functionalMessage = functionalMessage;
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the id.
	 * 
	 * @return <code>id</code>.
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the id.
	 * 
	 * @param <code>id</code>.
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * 
	 * <p>
	 * Method that returns the orderItemNumber.
	 * 
	 * @return <code>orderItemNumber</code>.
	 */
	public BigDecimal getOrderItemNumber() {
		return orderItemNumber;
	}


	/**
	 * 
	 * <p>
	 * Method that sets the orderItemNumber.
	 * 
	 * @param <code>orderItemNumber</code>.
	 */
	public void setOrderItemNumber(BigDecimal orderItemNumber) {
		this.orderItemNumber = orderItemNumber;
	}


	/**
	 * 
	 * <p>
	 * Method that returns the customerOrderType.
	 * 
	 * @return <code>customerOrderType</code>.
	 */
	public String getCustomerOrderType() {
		return customerOrderType;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the customerOrderType.
	 * 
	 * @param <code>customerOrderType</code>.
	 */
	public void setCustomerOrderType(String customerOrderType) {
		this.customerOrderType = customerOrderType;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the customerOrderStatus.
	 * 
	 * @return <code>customerOrderStatus</code>.
	 */
	public String getCustomerOrderStatus() {
		return customerOrderStatus;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the customerOrderStatus.
	 * 
	 * @param <code>customerOrderStatus</code>.
	 */
	public void setCustomerOrderStatus(String customerOrderStatus) {
		this.customerOrderStatus = customerOrderStatus;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the purchaseOrderNumber.
	 * 
	 * @return <code>purchaseOrderNumber</code>.
	 */
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the purchaseOrderNumber.
	 * 
	 * @param <code>purchaseOrderNumber</code>.
	 */
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the interactionDate.
	 * 
	 * @return <code>interactionDate</code>.
	 */
	public Calendar getInteractionDate() {
		return interactionDate;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the interactionDate.
	 * 
	 * @param <code>interactionDate</code>.
	 */
	public void setInteractionDate(Calendar interactionDate) {
		this.interactionDate = interactionDate;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the description.
	 * 
	 * @return <code>description</code>.
	 */	
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the description.
	 * 
	 * @param <code>description</code>.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the customerOrderItem.
	 * 
	 * @return <code>customerOrderItem</code>.
	 */
	public List<CustomerOrderItem> getCustomerOrderItem() {
		return customerOrderItem;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the customerOrderItem.
	 * 
	 * @param <code>customerOrderItem</code>.
	 */
	public void setCustomerOrderItem(List<CustomerOrderItem> customerOrderItem) {
		this.customerOrderItem = customerOrderItem;
	}		
	/**
	 * 
	 * <p>
	 * Method that returns the partyInteractionRole.
	 * 
	 * @return <code>partyInteractionRole</code>.
	 */
	public PartyInteractionRole getPartyInteractionRole() {
		return partyInteractionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the partyInteractionRole.
	 * 
	 * @param <code>partyInteractionRole</code>.
	 */
	public void setPartyInteractionRole(PartyInteractionRole partyInteractionRole) {
		this.partyInteractionRole = partyInteractionRole;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the functionalMessage.
	 * 
	 * @return <code>functionalMessage</code>.
	 */
	public FunctionalMessage getFunctionalMessage() {
		return functionalMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the functionalMessage.
	 * 
	 * @param <code>functionalMessage</code>.
	 */
	public void setFunctionalMessage(FunctionalMessage functionalMessage) {
		this.functionalMessage = functionalMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the errorMessage.
	 * 
	 * @return <code>errorMessage</code>.
	 */
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the errorMessage.
	 * 
	 * @param <code>errorMessage</code>.
	 */
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
}
