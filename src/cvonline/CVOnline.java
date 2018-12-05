/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvonline;

import controllers.UserInterface;
import controllers.UsersController;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.LowonganPekerjaan;
import entities.Users;
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
        UserInterface ui = new UsersController(sessionFactory);
        
        Users users = new Users(12, "eko", "achmadeko003@gmail.com", "ekoeko123", "admin");
        LowonganPekerjaan lp = new LowonganPekerjaan();
        System.out.println(daoi.doDML(users, false));
    }
    
}
