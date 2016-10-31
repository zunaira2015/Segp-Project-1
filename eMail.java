package raat2;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class eMail {
 // public static void main(String[] args) {
  public void senteMail (String a){	  
	
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
//     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
//     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
//     props.put("mail.store.protocol", "pop3");
//     props.put("mail.transport.protocol", "smtp");
     
     final String username = "patsystemsegp@gmail.com";//
     final String password = "studentsupportoffice";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
     Message msg = new MimeMessage(session);

  // -- Set the FROM and TO fields --
     msg.setFrom(new InternetAddress(username));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(a,false));
     
     msg.setSubject("Password");
     msg.setText("Your password is sso");
     Transport.send(msg);
     System.out.println("Email sent.");
     JOptionPane.showMessageDialog(null, "Email successfully sent");
  }catch (MessagingException e){
	  JOptionPane.showMessageDialog(null, "Error in sending email");
	  System.out.println("Error: " + e);}
  }
}