/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nitani
 */
public class inputImage {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
        InputStream is = null;
//        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "CVWAH", "ekoeko123");

            PreparedStatement ps = con.prepareStatement("insert into IMGTABLE values(?,?)");
//            
//            File file = new File("C:\\Users\\Nitani\\Pictures\\1.png");
//            
//            FileInputStream imageInFile = new FileInputStream(file);
//            byte imageData[] = new byte[(int) file.length()];
//            imageInFile.read(imageData);
//            System.out.println(imageData.hashCode());
// 
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        File file = new File("C:\\Users\\Nitani\\Pictures\\Error.jpg");
 
        FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
 
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum); 
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            
        }
 
        byte[] bytes = bos.toByteArray();
        System.out.println(bytes);
        ps.setString(1, "ddwaa");
        ps.setBytes(2, bytes);
    }
}
