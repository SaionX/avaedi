package es.caib.avaedi.at4forms.front.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import es.caib.avaedi.at4forms.common.util.StringUtils;
import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;



/**
 * Clase para la envío de emails
 * @author agarcia
 */
public class Email {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(Email.class);

	/**
	 * Lista de servidores considerados de desarrollo. En caso de que se esté corriendo en uno de ellos,
	 * se ejecuta automáticamente en TEST_MODE
	 */
	protected final static String[] SERVIDORES_DESARROLLO = {"dgtic", "javadev", "in.at4.net", "localhost", "ws-011-dir"};

	/**
	 * Cuando TEST_MODE = true, se envía sólo email a emailTest
	 */
    protected static boolean TEST_MODE = false;

    /**
     * Email al que enviar en modo de test
     */
    public static final String emailTest = "agarcia@at4.net";

	/**
	 * Método para el envio de un correo electrónico
	 * @param from
	 * @param replyTo
	 * @param toAddress
	 * @param subject
	 * @param body
	 * @param fileName
	 * @param zip
	 * @return true si el envio ha ido correctamente, false en caso contrario
	 * @throws MessagingException
	 */
	public static boolean enviaEmail( String from, String replyTo, String toAddress, String subject, String body, String fileName, byte[] zip) throws MessagingException {

		try {
			String hostName;
			hostName = InetAddress.getLocalHost().getHostName().toLowerCase();
			for (int i = 0; i < SERVIDORES_DESARROLLO.length; i++) {
				if (hostName.indexOf(SERVIDORES_DESARROLLO[i]) != -1){
					TEST_MODE = true;
					break;
				}
			}
		} catch (UnknownHostException e) {
			log.error(e.getMessage(), e);
		}


		if (TEST_MODE) {
			if (log.isDebugEnabled()) {
				log.debug(">>> testMode: (To: " + emailTest + ")");
			}
			toAddress = emailTest;
		}

		boolean envioRealizado = true;
		// Obtenemos la sesión para el envio
        Session session = null;
		try {
	        Context initial = new InitialContext();
	        session = (Session)PortableRemoteObject.narrow(initial.lookup("java:comp/env/mail/Mail"), Session.class);
		} catch (NamingException e) {
			envioRealizado = false;
			log.error(e.getMessage(), e);
		}

		// Creación y envio del correo
		if (session != null) {

			MimeMultipart multipart = new MimeMultipart();

			MimeMessage msg = new MimeMessage(session);

			// From
			if ( !StringUtils.isEmpty(from) ){
				msg.setFrom( new InternetAddress(from) );
			} else {
				if ( (session.getProperty("mail.from") != null) && !session.getProperty("mail.from").equals("") ) {
					//Del archivo "mail-service.xml" del JBoss
					msg.setFrom(new InternetAddress(session.getProperty("mail.from")));
				}
			}

			// Reply To
			if ( !StringUtils.isEmpty(replyTo) ) {
				InternetAddress [] iAddress = new InternetAddress[1];
				iAddress[0] = new InternetAddress(replyTo);
				msg.setReplyTo(iAddress);
			}

			// To
			if ( !StringUtils.isEmpty(toAddress) ){
				msg.setRecipients(Message.RecipientType.TO, toAddress);
			}else{
				envioRealizado = false;
			}

			// Subject
			if ( !StringUtils.isEmpty(subject) ){
				msg.setSubject(subject);
			}

			// Date
			msg.setSentDate(new java.util.Date());

			// Body
			MimeBodyPart messageBodyPartI = new MimeBodyPart();
			if ( ( body != null) && !body.equals("") ) {
				messageBodyPartI.setText(body);
				multipart.addBodyPart(messageBodyPartI);
			}

			/*
			 * http://mail-archives.apache.org/mod_mbox/ws-axis-user/200504.mbox/%3C1112728161.3871.45.camel@webservice.providerlink.com%3E
			 */
			// File
			if ( zip != null ){
				MimeBodyPart messageBodyPartII = new MimeBodyPart();

				if ( !StringUtils.isEmpty(fileName) ){
					messageBodyPartII.setFileName(fileName);
				}else{
					messageBodyPartII.setFileName("file.zip");
				}
				messageBodyPartII.setHeader("Content-Type", "application/zip");
				messageBodyPartII.setDataHandler( new DataHandler(new BufferedDataSource(zip, fileName, "application/zip")) );
				messageBodyPartII.setHeader("Content-ID","<zipSolicitud>");

				multipart.addBodyPart(messageBodyPartII);
			}

			msg.setContent(multipart);
			Transport.send(msg);

        } else {
        	envioRealizado = false;
        	log.debug("enviaEmailAvaluacio ERROR - no se ha encontrado servicio de correo");
        }

		return envioRealizado;

	}

}
