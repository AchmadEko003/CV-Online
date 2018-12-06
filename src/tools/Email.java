/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Nitani
 */
public class Email {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.port", "465");//default port dari smptp

            Session session = Session.getInstance(properties);
            session.setDebug(true);

            MimeMessage pesan = new MimeMessage(session);
            pesan.setFrom("achmadeko009@gmail.com"); //isi dengan gmail kalian sendiri, biasanya sama nanti dengan username
            pesan.setRecipient(Message.RecipientType.TO, new InternetAddress("achmadeko003@gmail.com"));//isi dengan tujuan email
            pesan.setSubject("Java Mail coba");
            pesan.setText("Email dikirim menggunakan Java Mail.");

            String username = "achmadeko009@gmail.com"; //ganti dengan gmail kalian sendiri
            String password = "Makoto_Yuki009"; //ganti dengan password kalian sendiri
            Transport.send(pesan, username, password);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

}

