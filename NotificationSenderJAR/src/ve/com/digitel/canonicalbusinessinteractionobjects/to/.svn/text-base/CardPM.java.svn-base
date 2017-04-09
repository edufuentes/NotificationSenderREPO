package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "name", "description","paymentMethodType","cvv" ,"cardHolderName","idCardHolderName","cardNumber","addresses"})
public class CardPM implements Serializable {
	
	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = -1660743711152735780L;

	/**
	 * Id del método de pago.
	 */
	@XmlElement(required=false, nillable=false)
	private String id;	
	
	/**
	 * Nombre del método de pago.
	 */
	@XmlElement(required=false, nillable=false)
	private String name;	
	
	/**
	 * Descripción de la forma de pago.
	 */
	@XmlElement(required=false, nillable=false)
	private String description; 	 
	
	/**
	 * Tipo de método de pago: DEBIT|CREDIT.
	 */
	@XmlElement(required=true, nillable=false)
	private String paymentMethodType;	
	
	/**
	 * Número de verificación de pago.
	 */
	@XmlElement(required=false, nillable=false)
	private Integer cvv;	
	
	/**
	 * Nombre del titular de la tarjeta.
	 */
	@XmlElement(required=false, nillable=false)
	private String cardHolderName;	
	
	/**
	 * Cédula de Identidad del Titular de la tarjeta.
	 */
	@XmlElement(required=false, nillable=false)
	private String idCardHolderName;	
	
	/**
	 * Número de la tarjeta encapsulado.
	 */
	@XmlElement(required=true, nillable=false)
	private String cardNumber;
	
	/**
	 * Dirección de facturación de la tarjeta.
	 */
	@XmlElement(required=false, nillable=false)
	private String addresses;

	/**
	 * <p>Constructor default without parameters.
	 */	
	public CardPM() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */
	public CardPM(String id, String name, String description,
			String paymentMethodType, Integer cvv, String cardHolderName,
			String idCardHolderName, String cardNumber, String addresses) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.paymentMethodType = paymentMethodType;
		this.cvv = cvv;
		this.cardHolderName = cardHolderName;
		this.idCardHolderName = idCardHolderName;
		this.cardNumber = cardNumber;
		this.addresses = addresses;
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
	 * Method that returns the name.
	 * 
	 * @return <code>name</code>.
	 */	
	public String getName() {
		return name;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the name.
	 * 
	 * @param <code>name</code>.
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Method that returns the paymentMethodType.
	 * 
	 * @return <code>paymentMethodType</code>.
	 */	
	public String getPaymentMethodType() {
		return paymentMethodType;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the paymentMethodType.
	 * 
	 * @param <code>paymentMethodType</code>.
	 */	
	public void setPaymentMethodType(String paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the cvv.
	 * 
	 * @return <code>cvv</code>.
	 */		
	public Integer getCvv() {
		return cvv;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the cvv.
	 * 
	 * @param <code>cvv</code>.
	 */	
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the cardHolderName.
	 * 
	 * @return <code>cardHolderName</code>.
	 */	
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the cardHolderName.
	 * 
	 * @param <code>cardHolderName</code>.
	 */		
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the idCardHolderName.
	 * 
	 * @return <code>idCardHolderName</code>.
	 */	
	public String getIdCardHolderName() {
		return idCardHolderName;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the idCardHolderName.
	 * 
	 * @param <code>idCardHolderName</code>.
	 */	
	public void setIdCardHolderName(String idCardHolderName) {
		this.idCardHolderName = idCardHolderName;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the cardNumber.
	 * 
	 * @return <code>cardNumber</code>.
	 */	
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the cardNumber.
	 * 
	 * @param <code>cardNumber</code>.
	 */	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the addresses.
	 * 
	 * @return <code>addresses</code>.
	 */	
	public String getAddresses() {
		return addresses;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the addresses.
	 * 
	 * @param <code>addresses</code>.
	 */	
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}	
	

}
