/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvonline;

import interfaces.UserInterface;
import controllers.UserControllers;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.LowonganPekerjaan;
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

//        Users users = new Users(12, "eko", "achmadeko003@gmail.com", "ekoeko123", "admin");
//        Perusahaan p = new Perusahaan(1, "MII", "Jakarta");
//        LowonganPekerjaan lp = new LowonganPekerjaan(21, "Back-end", "Dibutuhkan back-end developer segera", "A", new Perusahaan(1), new Users(32));

//        System.out.println(users.getLowonganPekerjaanId());
//        System.out.println(ui.register("32", "makoto", "achmadeko009@gmail.com", "Makoto_Yuki009", "admin"));
//        System.out.println(ui.search("achmadeko@gmail.com"));
    }
}
