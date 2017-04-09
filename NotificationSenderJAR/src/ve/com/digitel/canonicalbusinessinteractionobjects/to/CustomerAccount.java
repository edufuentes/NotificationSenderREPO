package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id","accountStatus", "accountType","accountNumber","vipCode","payment","cardPM"})
public class CustomerAccount implements Serializable {

	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 7398653332109885040L;
	
	/**
	 * Identificador de la cuenta.
	 */	
	@XmlElement(required=true, nillable=false)	
	private String id;
	
	/**
	 * Estado de la cuenta.
	 */	
	@XmlElement(required=false, nillable=false)		
	private String accountStatus;
	
	/**
	 * Tipo de cuenta.
	 */	
	@XmlElement(required=false, nillable=false)		
	private String accountType;
	
	/**
	 * Número de la cuenta en Kenan.
	 */	
	@XmlElement(required=false, nillable=false)		
	private Integer accountNumber;	
	
	/**
	 * Código VIP de la cuenta Kenan.
	 */	
	@XmlElement(required=false, nillable=false)		
	private String vipCode;	
	
	/**
	 * Pago del cliente.
	 */	
	@XmlElement(required=false, nillable=false)		
	private List<Payment>payment;
	
	/**
	 * Objeto que contiene la información de la tarjeta de crédito del cliente.
	 */	
	@XmlElement(required=false, nillable=false)		
	private List<CardPM>cardPM;	

	/**
	 * <p>Constructor default without parameters.
	 */	
	public CustomerAccount() {
		super();
	}

	/**
	 * <p>Constructor with parameters.
	 */	
	public CustomerAccount(String id, String accountStatus, String accountType,
			Integer accountNumber, String vipCode, List<Payment> payment,List<CardPM>cardPM) {
		super();
		this.id = id;
		this.accountStatus = accountStatus;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.vipCode = vipCode;
		this.payment = payment;
		this.cardPM = cardPM;
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
	 * Method that returns the accountStatus.
	 * 
	 * @return <code>accountStatus</code>.
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the accountStatus.
	 * 
	 * @param <code>accountStatus</code>.
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the accountType.
	 * 
	 * @return <code>accountType</code>.
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the accountType.
	 * 
	 * @param <code>accountType</code>.
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the accountNumber.
	 * 
	 * @return <code>accountNumber</code>.
	 */
	public Integer getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * 
	 * <p>
	 * Method that sets the accountNumber.
	 * 
	 * @param <code>accountNumber</code>.
	 */
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the vipCode.
	 * 
	 * @return <code>vipCode</code>.
	 */	
	public String getVipCode() {
		return vipCode;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the vipCode.
	 * 
	 * @param <code>vipCode</code>.
	 */
	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the payment.
	 * 
	 * @return <code>payment</code>.
	 */		
	public List<Payment> getPayment() {
		return payment;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the payment.
	 * 
	 * @param <code>payment</code>.
	 */
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}	

	/**
	 * 
	 * <p>
	 * Method that returns the cardPM.
	 * 
	 * @return <code>cardPM</code>.
	 */	
	public List<CardPM> getCardPM() {
		return cardPM;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the cardPM.
	 * 
	 * @param <code>cardPM</code>.
	 */	
	public void setCardPM(List<CardPM> cardPM) {
		this.cardPM = cardPM;
	}	
}
