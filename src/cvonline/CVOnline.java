/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvonline;

import controllers.UserInterface;
import controllers.UserControllers;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.LowonganPekerjaan;
import entities.Perusahaan;
import entities.Users;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Nitani
 */
public class CVOnline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        DAOInterface daoi = new GeneralDAO(sessionFactory);
        UserInterface ui = new UserControllers(sessionFactory);

        Users users = new Users(12, "eko", "achmadeko003@gmail.com", "ekoeko123", "admin");
//        Perusahaan p = new Perusahaan(1, "MII", "Jakarta");
//        LowonganPekerjaan lp = new LowonganPekerjaan(21, "Back-end", "Dibutuhkan back-end developer segera", "A", new Perusahaan(1), new Users(32));

//        System.out.println(users.getLowonganPekerjaanId());
//        System.out.println(ui.register("12", "makoto", "achmadeko@gmail.com", "ekoeko123", "admin"));
        System.out.println(ui.search("achmadeko@gmail.com"));
        
//        try {
//
//            Properties properties = new Properties();
//            properties.put("mail.smtp.host", "smtp.gmail.com");
//            properties.put("mail.smtp.auth", "true");
//            properties.put("mail.smtp.ssl.enable", "true");
//            properties.put("mail.smtp.port", "465");//default port dari smptp
//
//            Session session = Session.getInstance(properties);
//            session.setDebug(true);
//
//            MimeMessage pesan = new MimeMessage(session);
//            pesan.setFrom("achmadeko003@gmail.com"); //isi dengan gmail kalian sendiri, biasanya sama nanti dengan username
//            pesan.setRecipient(Message.RecipientType.TO, new InternetAddress("achmadeko003@gmail.com"));//isi dengan tujuan email
//            pesan.setSubject("Java Mail coba");
//            pesan.setText("Email dikirim menggunakan Java Mail.");
//
//            String username = "achmadeko003@gmail.com"; //ganti dengan gmail kalian sendiri
//            String password = "Makoto_Yuki003"; //ganti dengan password kalian sendiri
//            Transport.send(pesan, username, password);
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//        }
    }
}
