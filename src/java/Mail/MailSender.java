
package Mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
    public static boolean sendMail(String receiver, String title, String msg){
         boolean bool = true;
         final String password = "vbovhcoobfumxymj";
         final String from   = "manacuserkey@gmail.com";
         String to   = receiver;
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
     
        Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(from,password);
        }
        });
            try{
                System.out.println("within try mail sending");
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(from));
                        message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));
			message.setSubject(title);
			message.setText(msg);
                        Transport.send(message);
            }catch(Exception ex){
                bool = false;
                ex.printStackTrace();
            }
        return bool;
    }
}
