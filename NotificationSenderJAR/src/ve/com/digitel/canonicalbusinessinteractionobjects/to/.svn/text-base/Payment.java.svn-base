package ve.com.digitel.canonicalbusinessinteractionobjects.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id","confirmationNumber", "amount", "paymentDate","cardPM","thirdPartyPayeeAgency" })
public class Payment implements Serializable {
	
	/**
	 * Id for serialization version.
	 */
	private static final long serialVersionUID = 2547144167249907774L;

	/**
	 * Identificador del pago
	 */
	@XmlElement(required=true, nillable=false)
	private String id;
	
	
	/**
	 * Numero de Confirmación de la transacción
	 */
	@XmlElement(required=false, nillable=false)
	private Long confirmationNumber;
	
	
	
	/**
	 * Monto del pago
	 */
	@XmlElement(required=true, nillable=false)
	private Double amount;
	
	/**
	 * Fecha de pago
	 */
	@XmlElement(required=false, nillable=false)
	private Calendar paymentDate;
	
	/**
	 * Objeto que contiene la información de la tarjeta de crédito del cliente.
	 */
	@XmlElement(required=false, nillable=false)
	private CardPM cardPM;	
	
	/**
	 * Objeto que contiene la información de la cuenta de banco del cliente.
	 */
	@XmlElement(required=false, nillable=false)
	private ThirdPartyPayeeAgency thirdPartyPayeeAgency;
	
	
	/**
	 * <p>Constructor default without parameters.
	 */
	public Payment() {
		super();
	}
	

	/**
	 * <p>Constructor with parameters.
	 */
	public Payment(String id, Long confirmationNumber, Double amount, Calendar paymentDate, CardPM cardPM,
			ThirdPartyPayeeAgency thirdPartyPayeeAgency) {
		super();
		this.id = id;
		this.confirmationNumber = confirmationNumber;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.cardPM = cardPM;
		this.thirdPartyPayeeAgency = thirdPartyPayeeAgency;
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
	 * Method that returns the amount of the payment.
	 * 
	 * @return <code>amount</code>.
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the amount of the payment.
	 * 
	 * @param <code>amount</code>.
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the date of the payment.
	 * 
	 * @return <code>paymentDate</code>.
	 */
	public Calendar getPaymentDate() {
		return paymentDate;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the date of the payment.
	 * 
	 * @param <code>paymentDate</code>.
	 */
	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the date of the cardPM.
	 * 
	 * @return <code>cardPM</code>.
	 */
	public CardPM getCardPM() {
		return cardPM;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the date of the cardPM.
	 * 
	 * @param <code>cardPM</code>.
	 */
	public void setCardPM(CardPM cardPM) {
		this.cardPM = cardPM;
	}

	/**
	 * 
	 * <p>
	 * Method that returns the date of the thirdPartyPayeeAgency.
	 * 
	 * @return <code>thirdPartyPayeeAgency</code>.
	 */
	public ThirdPartyPayeeAgency getThirdPartyPayeeAgency() {
		return thirdPartyPayeeAgency;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the date of the thirdPartyPayeeAgency.
	 * 
	 * @param <code>thirdPartyPayeeAgency</code>.
	 */
	public void setThirdPartyPayeeAgency(ThirdPartyPayeeAgency thirdPartyPayeeAgency) {
		this.thirdPartyPayeeAgency = thirdPartyPayeeAgency;
	}


	/**
	 * 
	 * <p>
	 * Method that returns the date of the confirmationNumber.
	 * 
	 * @return <code>confirmationNumber</code>.
	 */
	public Long getConfirmationNumber() {
		return confirmationNumber;
	}

	/**
	 * 
	 * <p>
	 * Method that sets the date of the confirmationNumber.
	 * 
	 * @param <code>confirmationNumber</code>.
	 */
	public void setConfirmationNumber(Long confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	
	
	
}
