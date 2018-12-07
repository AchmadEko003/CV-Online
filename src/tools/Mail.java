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
public class Mail {

    public boolean Send(String email, String passwords) {
        boolean hasil = false;
        try {

            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.port", "465");//default port dari smptp

            Session session = Session.getInstance(properties);
            session.setDebug(true);

            MimeMessage pesan = new MimeMessage(session);
            pesan.setFrom(email); //isi dengan gmail kalian sendiri, biasanya sama nanti dengan username
            pesan.setRecipient(Message.RecipientType.TO, new InternetAddress("achmadeko003@gmail.com"));//isi dengan tujuan email
            pesan.setSubject("Pemberitahuan berhasil register");
            pesan.setText("Anda telah berhasil melakukan registrasi CV Online.");

            String username = email; //ganti dengan gmail kalian sendiri
            String password = passwords; //ganti dengan password kalian sendiri
            Transport.send(pesan, username, password);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return hasil;
    }
}
