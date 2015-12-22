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


public class PalRes {
    
      private static List<String> tipos;
    
    /**
     *
     */
    public PalRes()
    {
        tipos = new ArrayList<>();
        tipos.add("declara");
        tipos.add("num");
        tipos.add("letra");
        tipos.add("letra");
        tipos.add("cadena");
        tipos.add("booleano");
        tipos.add("V");
        tipos.add("F");
        tipos.add("como");
        tipos.add("inicio");
        tipos.add("fin");
        tipos.add("funcion");
        tipos.add("retorna");
        tipos.add("llamar");
        tipos.add("si");
        tipos.add("entonces");
        tipos.add("de lo contrario");
        tipos.add("mientras");
        tipos.add("desde");
        tipos.add("hasta");
        tipos.add("muestra");
        tipos.add("leer");
        tipos.add("como");
                
    }
    
    public static boolean esPaReservada(String valor)
    {   
        return tipos.contains(valor);
    }
    
}
