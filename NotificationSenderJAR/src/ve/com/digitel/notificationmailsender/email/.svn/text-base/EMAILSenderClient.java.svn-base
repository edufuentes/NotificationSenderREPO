/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.digitel.notificationmailsender.email;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationmailsender.email.to.EmailTO;
import ve.com.digitel.notificationsender.util.AppProperties;



/**
 *
 * @author Administrador
 */
public class EMAILSenderClient {

    private static Logger logger = BSSIntLogger.getBSSIntLogger(EMAILSenderClient.class);
    public static String V_OUT_COD_ERROR = "p_cod_error";
    public static String V_OUT_MSG_ERROR = "p_msg_error";
    private SMTPClient sMTPClient = new SMTPClient();

    public void setEndpoint(String endPoint) {
        sMTPClient.setUrl(AppProperties.getProperty(endPoint));
    }

    public void setPort(String port) {
        sMTPClient.setPort(AppProperties.getProperty(port));
    }

    public Map<String, String> sendPswdByEMAIL(String mailUserName, String password) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("sendPswdByEMAIL (" + mailUserName + " , " + password + ") - begin");
        }

        String smtpServerSender = AppProperties.getProperty("MAIL_SMTP_SERVER_SENDER");
        String smtpServerPswd = AppProperties.getProperty("MAIL_SMTP_SERVER_PSWD");

        String mailSubject = AppProperties.getProperty("MAIL_SUBJECT");
        String mailText = AppProperties.getProperty("MAIL_TEXT");
        String mailEmailAdmin = AppProperties.getProperty("MAIL_EMAIL_ADMIN");

        String mailMode = AppProperties.getProperty("MAIL_MODE");

        mailText = mailText.replaceAll("%U", mailUserName);
        mailText = mailText.replaceAll("%P", password);

        EmailTO email = new EmailTO();
        email.setFrom(mailEmailAdmin);
        email.setTo(mailUserName);
        email.setSubject(mailSubject);
        email.setDate(new Date());
        email.setData(mailText);

        if (logger.isDebugEnabled()) {
            logger.debug("Enviando mensaje: (" + mailText + ")" + "Remitente: " + mailEmailAdmin);
        }


        sMTPClient.setUserPass(smtpServerSender, smtpServerPswd);
        sMTPClient.connect(mailMode);
        sMTPClient.enviarEmail(email);

        logger.info("EMAIL enviado con exito a: " + mailUserName);

        Map<String, String> response = new HashMap<String, String>();
        response.put(V_OUT_COD_ERROR, "0");
        response.put(V_OUT_MSG_ERROR, AppProperties.getProperty("WSAUT-00"));
        return response;
    }
}
