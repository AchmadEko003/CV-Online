/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvonline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nitani
 */
public class test {

    public static void main(String[] args) {
//        Email validation
        String a = "user.adaw@domain.com";
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        if(matcher.matches()){
            System.out.println("Benar");
        }
        else{
            System.out.println("Salah");
        }
        System.out.println(matcher.matches());
    }
}
