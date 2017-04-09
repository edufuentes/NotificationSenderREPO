package ve.com.digitel.notificationmailsender.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ve.com.digitel.notificationmailsender.email.to.EmailTO;




/**
 * Clase SMTPClient para el envio de Email a un subscriptor no Digitel.<br /><br />
 *
 * @author  FYC CORP
 * @version 1.0
 * @since   SDK 1.6 2009/12/02
 */

public class SMTPClient {

    /**
     * Identificador del Usuario para el envio de Email.
     */
    private String username;

    /**
     * Clave del Usuario.
     */
    private String password;

    /**
     * Direccion del Servidor de Correo.
     */
    private String url;

    /**
     * Puerto del Servidor de Correo.
     */
    private String port;

    /**
     * Session para el envio de Email.
     */
    private Session session;

    /**
     * Retorna la clave del usuario.
     *
     * @return <code>password</code>.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la clave del usuario.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna el identificador del usuario.
     *
     * @return  <code>username</code>.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retorna la direccion del Servidor de Email.
     *
     * @return <code>url</code>.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Establece la direccion del Servidor de Email.
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Retorna el puerto del Servidor de Email.
     *
     * @return  <code>port</code>.
     */
    public String getPort() {
        return port;
    }

    /**
     * Establece el puerto del Servidor de Email.
     *
     * @param port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Clase para realizar la Validacion de Autenticacion.
     */
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getUsername(), getPassword());
        }
    }

    /**
     * Metodo donde se inicializa los datos del usuario para realizar la conexion.
     *
     * @param username
     * @param password
     */
    public void setUserPass(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    /**
     * Metodo que establece la configuracion y conexion con el servidor de Correo.
     */
    public void connect(String mode) {
        Properties props = new Properties();

        props.put("mail.smtp.host", getUrl());
        props.put("mail.smtp.port", getPort());
        props.put("mail.smtp.debug", "true");

	if(mode.equals("AUTH")){
	    props.put("mail.smtp.user", getUsername());
	    props.put("mail.smtp.auth", "true");
            Authenticator auth = new SMTPAuthenticator();
            session = Session.getInstance(props, auth);
	} else {
            session = Session.getDefaultInstance(props);
        }
        session.setDebug(false);
    }

    /**
     * Metodo que realiza el emvio del Email al Subscriptor no Digitel.
     *
     * @param email EmailTO
     * @throws java.lang.Exception
     */
    public void enviarEmail(EmailTO email) throws Exception {
        Message mensaje = new MimeMessage(session);
        mensaje.setSubject(email.getSubject());
        mensaje.setFrom(new InternetAddress(email.getFrom()));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
        mensaje.setContent(email.getData(), "text/html");
        Transport.send(mensaje);
    }
}
