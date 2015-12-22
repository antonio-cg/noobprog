/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex;

/**
 *
 * @author antoniocg
 */
public class ValorTipoInvalido extends Exception {
    
    public ValorTipoInvalido(String M,String N,String Z)
    {
        System.out.println("Error la Variable "+M+" del tipo " + N + " no puede tener el valor de " + Z );
        
    
    }
}
