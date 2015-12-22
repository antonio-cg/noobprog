/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Lexico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antoniocg
 */
public class tipos {
    private static  List<String> tipos;

    public tipos() {
        this.tipos = new ArrayList<>();
        tipos.add("num");
        tipos.add("letra");
        tipos.add("cadena");
        tipos.add("booleano");
    }
    
    public static boolean esTipoValido(String s)
    {
        return tipos.contains(s);
    }
}
