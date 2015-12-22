/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author antoniocg
 */
public class Utils {
    /**
     * 
     * @param s 
     * @return 
     */
    public static String[] getTokens(String s)
    {
        
        
        String[] datos;
        String limpia = s.replaceAll("(\\w|\\s)=(\\s|\\w)", "$1 = $2");  
        
        StringTokenizer tokens = new StringTokenizer(limpia);
        datos = new String[tokens.countTokens()];
        int x=0;
        while(tokens.hasMoreTokens())
        {
            datos[x] = tokens.nextToken();
            x++;
        }
        return datos;
    }
    
    public static String[] getTokens2(String s)
    {
     return s.replaceAll("^\"", "").split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");


    
    }
}
