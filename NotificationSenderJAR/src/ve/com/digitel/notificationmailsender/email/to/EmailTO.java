package ve.com.digitel.notificationmailsender.email.to;

import java.util.Date;

/**
 * Transfer Object EmailTO, encapsula la información básica asociada
 * al envio de Correo Electronico a un cliente que invoca algún WS. <br /><br />
 *
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6 2009/12/02
 */
public class EmailTO {

    /**
     * Destino del Correo electronico
     */
    private String to;
    /**
     * Destinatario del correo electronico
     */
    private String from;
    /**
     * Campo para referir con copia carbon el correo electronico
     */
    private String ccc;
    /**
     * Asunto o motivo del correo electronico
     */
    private String subject;
    /**
     * Texto del correo electronico
     */
    private String data;
    /**
     * Fecha de envio del correo electronico
     */
    private Date date;

    /**
     * Establece el destino del correo electronico.
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Retorna el Destino del  correo electronico.
     * @return  <code>to</code>.
     */
    public String getTo() {
        return to;
    }

    /**
     * Establece el Destinatario del correo electronico.
     * @param from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Retorna el Destinatario del correo electronico.
     * @return  <code>from</code>.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Establece otros destinos del correo electronico en modo copia carbon
     * @param ccc
     */
    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    /**
     * Retorna los destinos adicionales a los cuales se les copia el correo electronico.
     * @return  <code>ccc</code>.
     */
    public String getCcc() {
        return ccc;
    }

    /**
     * Establece el Asunto o motivo del correo electronico.
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Retorna el El Asunto o motivo del correo electronico.
     * @return  <code>subject</code>.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Establece El texto que se enviara por correo electronico.
     * @param data.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Retorna el texto del correo electronico.
     * @return  <code>data</code>.
     */
    public String getData() {
        return data;
    }

    /**
     * Retorna La fecha de envio del correo electronico.
     * @return  <code>date</code>.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Establece La fecha de envio del correo electronico.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
