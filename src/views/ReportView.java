/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import tools.HibernateUtil;

/**
 *
 * @author Nitani
 */
public class ReportView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReportView
     */
    public ReportView(String a) {
        initComponents();
        try {
            Connection con = HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry()
                    .getService(ConnectionProvider.class).getConnection();
            Path fileN = Paths.get("src" + File.separator + "Reports" + File.separator + a + ".jrxml");
            Path fileTo = Paths.get("src" + File.separator + "Reports" + File.separator + a + ".jasper");
            Path filename = fileN.toAbsolutePath();
            Path filetofill = fileTo.toAbsolutePath();
            String fileName = filename + "";
            String fileToFill = filetofill + "";
            JasperCompileManager.compileReport(fileName);
            Map param = new HashMap();
            JasperPrint jp = JasperFillManager.fillReport(fileToFill, param, con);
            JRViewer frame = new JRViewer(jp);
            Container c = getContentPane();
            c.setLayout(new BorderLayout());
            c.add(frame);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
