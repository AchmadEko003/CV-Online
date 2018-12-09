/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvonline;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nitani
 */
public class tests {

    private DecimalFormatSymbols dfs;
    private DecimalFormat dFormat;

    public static void main(String[] args) {
//        Email validation
//        String a = "user.adaw@domain.com";
//        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(a);
//        if(matcher.matches()){
//            System.out.println("Benar");
//        }
//        else{
//            System.out.println("Salah");
//        }
//        System.out.println(matcher.matches());
    }

    
        public void formatDesimal(String input){
        dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.'); //separator for the decimals
        dFormat = new DecimalFormat("#.##", dfs);
    }
}
